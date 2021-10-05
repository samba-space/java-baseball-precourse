package baseball.domain;

import java.util.Objects;

public class ResultVO {
    private int strike;
    private int ball;

    public ResultVO(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isFinish() {
        return strike == 3 ? true : false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultVO resultVO = (ResultVO) o;
        return getStrike() == resultVO.getStrike() && getBall() == resultVO.getBall();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStrike(), getBall());
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "strike=" + strike +
                ", ball=" + ball +
                '}';
    }
}