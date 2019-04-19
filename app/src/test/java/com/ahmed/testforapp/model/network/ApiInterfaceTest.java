package com.ahmed.testforapp.model.network;

import com.ahmed.testforapp.model.entity.ArticleServerResponse;
import com.ahmed.testforapp.util.KeyUtil;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.observers.TestObserver;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertEquals;

public class ApiInterfaceTest {


   @Mock
   private MockWebServer mockWebServer;
   private ApiInterface apiServices;

    @Before
    public void setUp() throws Exception {
        mockWebServer = new MockWebServer();
        apiServices = new Retrofit.Builder()
                .baseUrl(mockWebServer.url(KeyUtil.BASE_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiInterface.class);
    }

    @Test
    public void getArticle() throws InterruptedException {

        TestObserver<ArticleServerResponse> testObserver = new TestObserver<>();
        MockResponse mockedResponse = new MockResponse();
        mockedResponse.setResponseCode(200);
        mockedResponse.setBody("{}");
        mockWebServer.enqueue(mockedResponse);
        apiServices.getArticle(7,KeyUtil.API_VALUE)
                .subscribe(testObserver);
        testObserver.awaitTerminalEvent(2, TimeUnit.SECONDS);
        testObserver.assertNoErrors();
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals(request.getPath(), KeyUtil.BASE_URL);

        // test success value by search.json
        testObserver.assertValue(searchRepoResponse ->
                searchRepoResponse.getArticleServerServers()!= null &&
                        searchRepoResponse.getArticleServerServers().get(0).getId() == 63478084);

    }


    @After
    public void stopService() throws IOException {
        mockWebServer.shutdown();
    }




}