package com.example.han.adding;
import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunction;

public interface CreatingAccountInterface {
    @LambdaFunction
    BasicResponseClass addingCreateAccount(AccountClass request);
}
