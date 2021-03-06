package com.example.fixturesapplication.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.useCases.getMatches.GetMatchesStrategy
import com.example.fixturesapplication.R
import com.example.fixturesapplication.view.MatchesFragment


fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}

fun AppCompatActivity.replaceFragment(type: GetMatchesStrategy.Factory.Type) {
    var fragment = supportFragmentManager.findFragmentByTag(type.name)

    if (fragment == null)
        fragment = MatchesFragment.newInstance(type)

    val fragmentTransaction = supportFragmentManager
        .beginTransaction()
        .replace(R.id.container, fragment, type.name)

    if (type == GetMatchesStrategy.Factory.Type.FAVORITE)
        fragmentTransaction.addToBackStack(type.name)

    fragmentTransaction.commit()
}

