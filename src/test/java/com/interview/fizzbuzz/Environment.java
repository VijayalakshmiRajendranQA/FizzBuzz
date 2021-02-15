package com.interview.fizzbuzz;
/****
 * App Environments.
 */
public enum Environment {
    PROD_URI("http://fizzbuzz-exercise.herokuapp.com");
    private String uri;
    Environment(String value){
       this.uri = value;
    }
    public String value(){
        return this.uri;
    }
}
