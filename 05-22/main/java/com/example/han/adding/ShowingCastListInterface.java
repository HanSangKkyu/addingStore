package com.example.han.adding;

import java.util.ArrayList;

import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunction;
public interface ShowingCastListInterface {
    @LambdaFunction
    ArrayList<CastClass> addingShowCast(CastRequestClass request);
}
