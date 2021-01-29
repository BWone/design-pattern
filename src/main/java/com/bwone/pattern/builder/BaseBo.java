package com.bwone.pattern.builder;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class BaseBo<T> {
    private RequestHead head;
    private T body;
    private RequestFoot foot;

    public static class Builder<T>{
        private String brain;
        private String toe;

        // T类型主要用于设置body值
        private RequestHead head;
        private T body;
        private RequestFoot foot;

        // 级联调用返回类本身
        public Builder<T> brain(String brain){
            this.brain = brain;
            return this;
        }

        public Builder<T> toe(String toe){
            this.toe = toe;
            return this;
        }

        public Builder<T> head(RequestHead head){
            this.head = head;
            return this;
        }

        public Builder<T> body(T body){
            this.body = body;
            return this;
        }

        public Builder<T> foot(RequestFoot foot){
            this.foot = foot;
            return this;
        }

        // 这种方式可以设置所有属性,通过BaseBo的get方法获取
        public BaseBo<T> build(){
            BaseBo<T> baseBo = new BaseBo<>();
            RequestHead requestHead = new RequestHead();
            RequestFoot requestFoot = new RequestFoot();

            requestHead.setBrain(brain);

            requestFoot.setToe(toe);

            baseBo.setHead(requestHead);
            baseBo.setBody(body);
            baseBo.setFoot(requestFoot);
            return baseBo;
        }

        // 这种方式只设置单个属性
        public RequestHead buildHead(){
            RequestHead requestHead = new RequestHead();
            requestHead.setBrain(brain);
            return requestHead;
        }
        public RequestFoot buildFoot(){
            RequestFoot requestFoot = new RequestFoot();
            requestFoot.setToe(toe);
            return requestFoot;
        }

    }

    @Data
    public static class RequestHead{
        private String brain;
    }

    @Data
    public static class RequestFoot{
        private String toe;
    }

}
