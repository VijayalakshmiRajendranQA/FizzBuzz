package com.interview.fizzbuzz;
/****
 * App Endpoints.
 */
public enum Endpoint {
    FizzBuzz("/api/fizzbuzz-calculator");
    private String path;
    Endpoint(String value){
        this.path = value;
    }
    public String value(){
        return this.path;
    }

}
