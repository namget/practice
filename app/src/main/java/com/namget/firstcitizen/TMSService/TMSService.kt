package com.namget.firstcitizen.TMSService

class TMSService {


    //TODO 송금 요청이 완료 됐다는 메세지를 발송 ...
    //TODO 송금 요청이 실패 했을 경우 운영자한테 메세지 발송
    fun sendMessage(message: String, status: String) {
        println("송금요청 완료 ${message}")
        println("상태 업데이트 ${status}")
    }

    fun setErrorMessage(){

    }

}