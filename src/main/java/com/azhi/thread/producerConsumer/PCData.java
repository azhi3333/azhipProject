package com.azhi.thread.producerConsumer;

import lombok.Data;

/**
 * @author azhi
 * 2021/3/30 4:12 下午
 */
@Data
public final class PCData {
    private final int intData;

    public PCData(int intData) {
        this.intData = intData;
    }

    public PCData(String intData) {
        this.intData = Integer.valueOf(intData);
    }

    @Override
    public String toString() {
        return "intData=" + intData;
    }
}
