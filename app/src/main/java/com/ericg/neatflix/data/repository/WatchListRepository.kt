package com.ericg.neatflix.data.repository

import com.ericg.neatflix.data.local.MyListMovie
import com.ericg.neatflix.data.local.WatchListDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WatchListRepository @Inject constructor(private val database: WatchListDatabase) {
    suspend fun addToWatchList(movie: MyListMovie){
        database.moviesDao.addToWatchList(movie)
    }

    suspend fun exists(mediaId: Int): Int{
        return database.moviesDao.exists(mediaId)
    }

    suspend fun removeFromWatchList(movie: MyListMovie){
        database.moviesDao.removeFromWatchList(movie)
    }

    fun getFullWatchList(): Flow<List<MyListMovie>> {
       return database.moviesDao.getFullWatchList()
    }

    fun searchInWatchList(searchParam: String): Flow<List<MyListMovie>> {
        return database.moviesDao.searchWatchList(searchParam)
    }

    suspend fun deleteWatchList(){
        database.moviesDao.deleteWatchList()
    }
}