package com.shoppinglist.execom.shoppinglistapp.utils;

import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by mihajlo on 4/13/2017.
 */
@SharedPref(SharedPref.Scope.UNIQUE)
public interface Preferences {
    int id();
}
