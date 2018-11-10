package com.andreygritsay.criminalintent.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.andreygritsay.criminalintent.Crime;
import com.andreygritsay.criminalintent.database.CrimeDbSchema.CrimeTable;

import java.util.Date;
import java.util.UUID;

public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));
        int isSerious = getInt(getColumnIndex(CrimeTable.Cols.SEROIUS));
        String suspect = getString(getColumnIndex(CrimeTable.Cols.SUSPECT));
        String number = getString(getColumnIndex(CrimeTable.Cols.NUMBER));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolved(isSolved != 0);
        crime.setRequiresPolice(isSerious != 0);
        crime.setSuspect(suspect);
        crime.setNumber(number);
        return crime;
    }
}
