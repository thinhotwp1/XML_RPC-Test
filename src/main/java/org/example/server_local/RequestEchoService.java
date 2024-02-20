package org.example.server_local;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.Map;

@SpringBootApplication
@Controller
public class RequestEchoService {

    public static void main(String[] args) {
        SpringApplication.run(RequestEchoService.class, args);
    }

    @RequestMapping(value = "/**", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String echoRequest(
            @RequestBody(required = false) String requestBody,
            HttpServletRequest request) throws Exception {
        System.out.println("URL: "+ request.getRequestURI());
        System.out.println("Request Body: " +requestBody);
        String response = "Success";
        if(requestBody.contains("GetCapabilities")){
            System.out.println("Keep Alive Response");
            response = "{\n" +
                    "    \"Status\": \"Active\"\n" +
                    "}";
        }
        if(requestBody.contains("GetOffers")){
            System.out.println("GetOffers Response");
            response = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:wsa=\"http://schemas.xmlsoap.org/ws/2004/08/addressing\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><soap:Header><wsa:Action>http://comverse-in.com/prepaid/ccws/RetrieveSubscriberWithIdentityNoHistoryResponse</wsa:Action><wsa:MessageID>urn:uuid:401defe7-0fae-4a7e-8fe6-c38bd5a93c5f</wsa:MessageID><wsa:RelatesTo>urn:uuid:e60ce087-b8d6-407f-b04d-9c9b0efc8c4a</wsa:RelatesTo><wsa:To>http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous</wsa:To><wsse:Security><wsu:Timestamp wsu:Id=\"Timestamp-88d43721-49dd-4fbc-809e-ce13d2ff2398\"><wsu:Created>2023-11-14T02:54:46Z</wsu:Created></wsu:Timestamp></wsse:Security></soap:Header><soap:Body><RetrieveSubscriberWithIdentityNoHistoryResponse xmlns=\"http://comverse-in.com/prepaid/ccws\"><RetrieveSubscriberWithIdentityNoHistoryResult><SubscriberID>2439990167</SubscriberID><SubscriberPhoneBook /><SubscriberData><NotificationLanguage>Vietnamese</NotificationLanguage><RoamingCreditLimitAsString>0</RoamingCreditLimitAsString><CurrentState>Active</CurrentState><COSName>GTT_249_DAILY</COSName><PINChangeNeeded>false</PINChangeNeeded><LanguageName>Vietnamese</LanguageName><TimeZone>:GMT+7</TimeZone><OtherSysID>SPS_GTT_149_DAILY</OtherSysID><BillCycleDay>14</BillCycleDay><NotificationLevel>0</NotificationLevel><LimitType>NONE</LimitType><BonusPlan><BonusPlanName>BN_RECHARGE</BonusPlanName></BonusPlan><Balances><Balance><Balance>40727.42</Balance><AccountExpiration>0001-01-01T00:00:00.0000000+07:00</AccountExpiration><BalanceName>Core</BalanceName><NextMaximumSpendingLimit>0</NextMaximumSpendingLimit><TotalSpendingLimit>0</TotalSpendingLimit><AvailableBalance>40727.42</AvailableBalance><FundsType>BalanceOnly</FundsType><MaximumSpendingLimit>0</MaximumSpendingLimit><AvailableSpendingLimit>0</AvailableSpendingLimit><PrecisionPoint>2</PrecisionPoint></Balance><Balance><Balance>0</Balance><AccountExpiration>2038-01-18T23:59:59.0000000+07:00</AccountExpiration><BalanceName>Promotion</BalanceName><NextMaximumSpendingLimit>0</NextMaximumSpendingLimit><TotalSpendingLimit>0</TotalSpendingLimit><AvailableBalance>0</AvailableBalance><FundsType>BalanceOnly</FundsType><MaximumSpendingLimit>0</MaximumSpendingLimit><AvailableSpendingLimit>0</AvailableSpendingLimit><PrecisionPoint>2</PrecisionPoint></Balance></Balances><SPName>GTT</SPName><CreationDate>2022-04-14T08:34:23.0000000+07:00</CreationDate><DateEnterActive>2022-04-20T09:42:40.0000000+07:00</DateEnterActive><PreviousState>Suspended(S1)</PreviousState><PrevTransDate>2023-09-06T13:41:49.0000000+07:00</PrevTransDate><LastTransDate>2023-10-27T07:15:00.0000000+07:00</LastTransDate><AccountType>Individual</AccountType><LastCallCharge>1172.84</LastCallCharge><FreeFFChgAllowance>0</FreeFFChgAllowance><FFChangeCount>0</FFChangeCount><CurrencyCode>VND</CurrencyCode><PromisedPaymentAmount>0</PromisedPaymentAmount><PromisedPaymentDueDate>0001-01-01T00:00:00.0000000+07:00</PromisedPaymentDueDate><PromisedPaymentBalanceID>0</PromisedPaymentBalanceID><Accumulator><AccumulatorName>Recharge</AccumulatorName><Amount>0</Amount><ZeroDay>0</ZeroDay><Period>0</Period><NextResetAccumulatorTS>0001-01-01T00:00:00.0000000+07:00</NextResetAccumulatorTS></Accumulator><LoyaltyEnrollmentDate>0001-01-01T00:00:00.0000000+07:00</LoyaltyEnrollmentDate><NextLoyaltySyncDate>0001-01-01T00:00:00.0000000+07:00</NextLoyaltySyncDate><LoyaltyScaleRate>0</LoyaltyScaleRate><LoyaltyBonusScale>0</LoyaltyBonusScale></SubscriberData></RetrieveSubscriberWithIdentityNoHistoryResult></RetrieveSubscriberWithIdentityNoHistoryResponse></soap:Body></soap:Envelope>";
        }
        return response;
    }

    public void load(InputStream inputStream) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mp = null;
        mp = mapper.readValue(inputStream, Map.class);

        // In ra màn hình
        System.out.println("Parsed data:"+mp);
    }
}