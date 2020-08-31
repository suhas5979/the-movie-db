package com.lingga.themoviedb.core.domain.usecase.movie

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.lingga.themoviedb.core.data.Resource
import com.lingga.themoviedb.core.domain.model.Movie
import com.lingga.themoviedb.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieInteractor @Inject constructor(private val movieRepository: IMovieRepository) :
    MovieUseCase {

    override fun getAllMovie(): Flow<Resource<List<Movie>>> = movieRepository.getAllMovie()

    override suspend fun getMovie(id: Int): Flow<Movie> = movieRepository.getMovie(id)

    override fun setFavoriteMovie(movie: Movie, state: Boolean) =
        movieRepository.setFavoriteMovie(movie, state)

    override fun getFavoriteMovie(): LiveData<PagedList<Movie>> = movieRepository.getFavoriteMovie()
}