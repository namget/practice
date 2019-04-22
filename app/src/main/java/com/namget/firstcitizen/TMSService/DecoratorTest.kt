package com.namget.firstcitizen.TMSService

class DecoratorTest(val tmsService: TMSService) {


    //송금 결과를 고객에게 발송
    //TODO
    fun main(){
        tmsService.sendMessage("송금완료","완료")
    }


}