package org.legion.walls;

import org.legion.walls.models.ServerRequest;
import org.legion.walls.models.ServerResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by ishubhamsingh on 25/9/17.
 */

public interface RequestInterface {

    @POST("aexstats_api/")
    Observable<ServerResponse> operation(@Body ServerRequest request);

}