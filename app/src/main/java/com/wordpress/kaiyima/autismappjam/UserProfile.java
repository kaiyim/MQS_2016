package com.wordpress.kaiyima.autismappjam;

/**
 * Created by KyleMa on 4/19/16.
 */
public class UserProfile {

    private int _id;
    private String _username;
    private int _exp;

    public UserProfile(String username){
        this._username = username;
    }

    public void addExp(int exp){
        _exp += exp;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public void set_exp(int _exp) {
        this._exp = _exp;
    }

    public int get_exp() {
        return _exp;
    }

    public int get_id() {
        return _id;
    }

    public String get_username() {
        return _username;
    }
}
