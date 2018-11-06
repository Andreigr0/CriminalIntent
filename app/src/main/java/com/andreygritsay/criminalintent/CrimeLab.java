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
//        mCrimes.add(crime);
        mCrimes = new LinkedHashMap<>();
//        for (int i = 0; i < 21; i++) {
//            Crime crime = new Crime();
//            crime.setTitle("Crime #" + i);
//            crime.setSolved(i % 2 == 0);
//            crime.setRequiresPolice(i % 3 == 0); // Police
//            mCrimes.put(crime.getId(), crime);
//        }
    }

    public List<Crime> getCrimes() {
        return new ArrayList<>(mCrimes.values());
    }

    public Crime getCrime(UUID id) {
        return mCrimes.get(id);
    }

    public void addCrime(Crime c) {
        mCrimes.put(c.getId(), c);
    }

    public void deleteCrime(Crime c) {
        mCrimes.remove(c.getId());
    }

}
