package com.ademirespinoza.retosolera.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = arrayOf(ResponseEntity::class), version = 1)
@TypeConverters(ResultConverter::class)
abstract class PeliculasDatabase : RoomDatabase(){

    abstract fun responseDao():ResponseDao

    companion object{

        private var instance: PeliculasDatabase? = null

        fun getInstance(context: Context):PeliculasDatabase?{

            if(instance == null){
                instance = Room.databaseBuilder<PeliculasDatabase>(context.applicationContext,
                    PeliculasDatabase::class.java,"db_peliculas")
                    .allowMainThreadQueries() //para llamar a base de datos en el hilo principal
                    .addCallback(room)
                    .build()
            }

            return instance
        }

        private val room = object  : RoomDatabase.Callback(){

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                //PopulateDBAsyncTask(instance).execute()
            }
        }
    }



    /*class PopulateDBAsyncTask(instance: PeliculasDatabase?) : AsyncTask<Void,Void,Void>(){

        private val responseDao : ResponseDao? = instance?.responseDao()

        override fun doInBackground(vararg p0: Void?): Void? {

            responseDao?.insert(ResponseEntity(titulo = "Titulo01",descripcion = "Descripcion01"))
            responseDao?.insert(ResponseEntity(titulo = "Titulo01",descripcion = "Descripcion01"))
            responseDao?.insert(ResponseEntity(titulo = "Titulo01",descripcion = "Descripcion01"))
            responseDao?.insert(ResponseEntity(titulo = "Titulo01",descripcion = "Descripcion01"))
            responseDao?.insert(ResponseEntity(titulo = "Titulo01",descripcion = "Descripcion01"))
            responseDao?.insert(ResponseEntity(titulo = "Titulo01",descripcion = "Descripcion01"))

            return null
        }

    }*/
}