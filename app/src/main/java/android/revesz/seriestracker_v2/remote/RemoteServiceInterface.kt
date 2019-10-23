package android.revesz.seriestracker_v2.remote

import android.revesz.seriestracker_v2.data.EpisodeResponse
import android.revesz.seriestracker_v2.data.SeasonResponse
import android.revesz.seriestracker_v2.data.SeriesResponse
import com.squareup.okhttp.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteServiceInterface {

    @GET("tv/{tv_id}")
    suspend fun listSeries(@Path("tv_id") id: Int, @Query("api_key") apikey: String): SeriesResponse

    @GET("tv/{tv_id}/season/{season_number}")
    suspend fun getSeason(@Path("rv_id") id : Int, @Path("season_number") season_number : Int, @Query("api_key") apikey : String) : SeasonResponse

    @GET("tv/{tv_id}/season/{season_number}/episode/{episode_number}")
    suspend fun getEpisode(@Path("tv_id") id : Int, @Path("season_number") season_number : Int, @Path("episode_number") episode_number : Int, @Query("api_key") apikey : String): EpisodeResponse
}