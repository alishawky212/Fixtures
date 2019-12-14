package com.example.domain.useCases

import com.example.domain.models.Match
import com.example.domain.repository.FavoriteRepository
import io.reactivex.Completable
import javax.inject.Inject

class RemoveMatchFromFavoriteUseCase @Inject constructor(
    private val localRepository: FavoriteRepository
) {
    fun removeMatch(match:Match):Completable{
        return localRepository.removeMatch(match)
    }
}