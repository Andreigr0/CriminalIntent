package com.andreygritsay.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;
//    private List<Crime> mCrimes;
    private LinkedHashMap<UUID,Crime> mCrimes;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
//        mCrimes = new ArrayList<>();
        mCrimes = new LinkedHashMap<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            mCrimes.put(crime.getId(), crime);
//            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes() {
        return new ArrayList<>(mCrimes.values());
    }

    public Crime getCrime(UUID id) {
//        for (Crime crime : mCrimes) {
//            if (crime.getId().equals(id)) {
//                return crime;
//            }
//        }
        return mCrimes.get(id);
    }

}