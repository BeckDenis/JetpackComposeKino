package com.example.kino.db

import com.example.kino.screen.common.TypeEnum
import com.example.kino.db.model.CheckColumnDB
import com.example.kino.db.model.Genres
import com.example.kino.network.model.common.GenresApi
import io.reactivex.Single

interface DatabaseRepository {

    fun isNotEmptyGenresAll() : Single<CheckColumnDB>

    fun insertGenres(listGenres : List<GenresApi>, type : TypeEnum)

    fun getGenres(type: TypeEnum): Single<List<Genres>>
}