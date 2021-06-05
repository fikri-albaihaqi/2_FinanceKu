package com.example.financekuv2.ui.home;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.financekuv2.R;
import com.example.financekuv2.Transaksi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Transaksi.class}, version = 1, exportSchema = false)
public abstract class TransaksiRoomDatabase extends RoomDatabase {

  public abstract TransaksiDao transaksiDao();

  private static volatile TransaksiRoomDatabase INSTANCE;
  private static final int NUMBER_OF_THREADS = 4;
  static final ExecutorService databaseWriteExecutor =
          Executors.newFixedThreadPool(NUMBER_OF_THREADS);

  static TransaksiRoomDatabase getDatabase(final Context context) {
    if (INSTANCE == null) {
      synchronized (TransaksiRoomDatabase.class) {
        if (INSTANCE == null) {
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                  TransaksiRoomDatabase.class, "financeku")
                  .addCallback(sRoomDatabaseCallback)
                  .build();
        }
      }
    }
    return INSTANCE;
  }

  private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);

      // If you want to keep data through app restarts,
      // comment out the following block
      databaseWriteExecutor.execute(() -> {
        // Populate the database in the background.
        // If you want to start with more words, just add them.
        TransaksiDao dao = INSTANCE.transaksiDao();
//        dao.deleteAll();

        Transaksi transaksi = new Transaksi("Belanja Bulanan", -200000, R.drawable.ic_pengeluaran, "Lorem Ipsum", "11 September 2021", "Pengeluaran");
        dao.insert(transaksi);
        transaksi = new Transaksi("Gaji Pokok", 5000000, R.drawable.ic_pemasukan, "Gaji bulanan", "11 September 2021", "Pemasukan");
        dao.insert(transaksi);
        transaksi = new Transaksi("Ngopi", -40000, R.drawable.ic_pengeluaran, "Ngopi di warkop", "11 September 2021", "Pengeluaran");
        dao.insert(transaksi);
        transaksi = new Transaksi("Uang Makan", 300000, R.drawable.ic_pemasukan, "Lorem Ipsum", "11 September 2021", "Pemasukan");
        dao.insert(transaksi);
      });
    }
  };
}
