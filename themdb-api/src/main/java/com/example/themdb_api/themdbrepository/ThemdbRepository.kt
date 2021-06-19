package com.example.themdb_api.themdbrepository

import com.example.themdb_api.genres.GenresApi
import com.example.themdb_api.movie.MovieApi
import com.example.themdb_api.serials.SerialApi

interface ThemdbRepository {

    suspend fun getListGenresByMovie() : GenresApi

    suspend fun getListGenresBySerial() : GenresApi

    suspend fun getMovieByGenres(genresId: String): MovieApi

    suspend fun getPopularityMove(): MovieApi

    suspend fun getSerials(genresId: String): SerialApi

    suspend fun getPopularSerial(): SerialApi
}