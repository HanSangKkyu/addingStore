package com.example.han.adding;

import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunction;

import java.util.ArrayList;

public interface ShowingFundListInterface {
    @LambdaFunction
    ArrayList<PreviewClassFund> addingShowProject(FundRequestClass request);
}
