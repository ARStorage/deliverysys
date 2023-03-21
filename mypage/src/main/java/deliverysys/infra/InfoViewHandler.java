package deliverysys.infra;

import deliverysys.domain.*;
import deliverysys.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class InfoViewHandler {

    @Autowired
    private InfoRepository infoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {

            if (!ordered.validate()) return;

            // view 객체 생성
            Info info = new Info();
            // view 객체에 이벤트의 Value 를 set 함
            info.setOrderId(String.valueOf(ordered.getId()));
            info.setCustomerId(ordered.getCustomerId());
            info.setStatus(주문완료);
            // view 레파지 토리에 save
            infoRepository.save(info);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_1(@Payload OrderCanceled orderCanceled) {
        try {
            if (!orderCanceled.validate()) return;
                // view 객체 조회

                List<Info> infoList = infoRepository.findByOrderId(String.valueOf(orderCanceled.getId()));
                for(Info info : infoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    info.setStatus(주문 취소);
                // view 레파지 토리에 save
                infoRepository.save(info);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_2(@Payload Paid paid) {
        try {
            if (!paid.validate()) return;
                // view 객체 조회

                List<Info> infoList = infoRepository.findByOrderId(String.valueOf(paid.getId()));
                for(Info info : infoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    info.setStatus(결제 완료);
                // view 레파지 토리에 save
                infoRepository.save(info);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderRejected_then_UPDATE_3(@Payload OrderRejected orderRejected) {
        try {
            if (!orderRejected.validate()) return;
                // view 객체 조회

                List<Info> infoList = infoRepository.findByOrderId(orderRejected.getOrderId());
                for(Info info : infoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    info.setStatus(orderRejected.getStatus());
                // view 레파지 토리에 save
                infoRepository.save(info);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAccepted_then_UPDATE_4(@Payload OrderAccepted orderAccepted) {
        try {
            if (!orderAccepted.validate()) return;
                // view 객체 조회

                List<Info> infoList = infoRepository.findByOrderId(orderAccepted.getOrderId());
                for(Info info : infoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    info.setStatus(orderAccepted.getStatus());
                // view 레파지 토리에 save
                infoRepository.save(info);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_5(@Payload CookStarted cookStarted) {
        try {
            if (!cookStarted.validate()) return;
                // view 객체 조회

                List<Info> infoList = infoRepository.findByOrderId(cookStarted.getOrderId());
                for(Info info : infoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    info.setStatus(cookStarted.getStatus());
                // view 레파지 토리에 save
                infoRepository.save(info);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookFinished_then_UPDATE_6(@Payload CookFinished cookFinished) {
        try {
            if (!cookFinished.validate()) return;
                // view 객체 조회

                List<Info> infoList = infoRepository.findByOrderId(cookFinished.getOrderId());
                for(Info info : infoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    info.setStatus(cookFinished.getStatus());
                // view 레파지 토리에 save
                infoRepository.save(info);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookPickuped_then_UPDATE_7(@Payload CookPickuped cookPickuped) {
        try {
            if (!cookPickuped.validate()) return;
                // view 객체 조회

                List<Info> infoList = infoRepository.findByOrderId(cookPickuped.getOrderId());
                for(Info info : infoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    info.setStatus(cookPickuped.getStatus());
                // view 레파지 토리에 save
                infoRepository.save(info);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryFinished_then_UPDATE_8(@Payload DeliveryFinished deliveryFinished) {
        try {
            if (!deliveryFinished.validate()) return;
                // view 객체 조회

                List<Info> infoList = infoRepository.findByOrderId(deliveryFinished.getOrderId());
                for(Info info : infoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    info.setStatus(deliveryFinished.getStatus());
                // view 레파지 토리에 save
                infoRepository.save(info);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

