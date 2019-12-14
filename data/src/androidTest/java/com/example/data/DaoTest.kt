package com.example.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.runner.AndroidJUnit4
import org.junit.runner.RunWith
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.data.db.MyDatabase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@RunWith(AndroidJUnit4::class)
class DaoTest {

    private var mDatabase: MyDatabase? = null

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @Before
    @Throws(Exception::class)
    fun initDb() {
        mDatabase = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            MyDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()
    }

    @Test
    fun checkIfMatchExist(){
        mDatabase!!.dataBaseDao().insertMatch(creatMatchEntity()).test()
        mDatabase!!.dataBaseDao()
            .get(12)
            .test()
            .assertValue(listOf(creatMatchEntity()))
    }

    @Test
    fun insertAndRemoveMatch(){
        mDatabase!!.dataBaseDao().insertMatch(creatMatchEntity()).test()
        mDatabase!!.dataBaseDao()
            .delete(creatMatchEntity())
            .test()
            .assertComplete()
    }

    @Test
    fun insertAndGetMatchById() {
        mDatabase!!.dataBaseDao().insertMatch(creatMatchEntity()).test()
        mDatabase!!.dataBaseDao()
            .getFavoriteMatches()
            .test()
            .assertValue(listOf(creatMatchEntity()))

        @After
        @Throws(Exception::class)
        fun closeDb() {
            mDatabase?.close()
        }
    }
}
