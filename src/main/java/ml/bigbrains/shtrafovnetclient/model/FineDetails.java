package ml.bigbrains.shtrafovnetclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FineDetails {
    private String number;
    @JsonProperty("bill_date")
    private String billDate;
    private BigDecimal amount;
    @JsonProperty("amount_to_pay")
    private BigDecimal amountToPay;
// payment_status enum:
//    unknown: неизвестен/уточняется
//    nopaid: неоплачен
//    partpaid: частично оплачен
//    overpaid: переплачен
//    prepaid: предоплачен (есть сведения о попытке оплаты, но оплата ещё не дошла)
//    paid: оплачен
//    canceled: отменён/аннулирован
//    replaced: начисление заменено на новое. Ставится, когда ГИС ГМП перестаёт отвечать на запрос информации по старому УИНу и принудительно перенаправляет на новый, выписанный ФССП. Это происходит, когда штраф долго не оплачивается и администратор начисления жалуется на это приставам. По объяснению от ФССП старый штраф больше не подлежит оплате и нужно оплачивать новый. По нашему опыту если по реквизитам старого штрафа была произведена оплата, то это отразится на новом штрафе, у него уменьшится сумма или он отменится, но это происходит с очень большой задержкой, иногда в месяц
//    not_found: начисление не найдено в ГИС ГМП. Некоторые администраторы начислений долго передают информацию о штрафе в ГИС ГМП, поэтому есть ситуации, когда штраф есть например в базе МАДИ/АМПП, но его нет в ГИС ГМП
    @JsonProperty("payment_status")
    private String paymentStatus;
    @JsonProperty("discount_date")
    private String discountDate;
    @JsonProperty("discount_size")
    private Integer discountSize;
    @JsonProperty("replaced_with")
    private String replacedWith;
    @JsonProperty("change_status")
    private String changeStatus;
    @JsonProperty("change_status_reason")
    private String changeStatusReason;
    @JsonProperty("violation_date")
    private String violationDate;
    @JsonProperty("violator_name")
    private String violatorName;
    private String location;
    @JsonProperty("koap_code")
    private String koapCode;
    @JsonProperty("koap_text")
    private String koapText;
    @JsonProperty("division_name")
    private String divisionName;
    @JsonProperty("division_code")
    private String divisionCode;
    private String name;
// org enum:
//    org_unknown: неизвестно
//    gibdd: ГИБДД
//    ampp: АМПП
//    madi: МАДИ
//    fssp: ФССП
//    rostransnadzor: Ространснадзор (платон)
//    parking: Администраторы парковок, кроме москвы
    private String org;
    @JsonProperty("payee_username")
    private String payeeUsername;
    @JsonProperty("payee_inn")
    private String payeeInn;
    @JsonProperty("payee_kpp")
    private String payeeKpp;
    @JsonProperty("payee_oktmo")
    private String payeeOktmo;
    @JsonProperty("payee_kbk")
    private String payeeKbk;
    @JsonProperty("payee_bank_name")
    private String payeeBankName;
    @JsonProperty("payee_bank_bik")
    private String payeeBankBik;
    @JsonProperty("payee_bank_account")
    private String payeeBankAccount;
    @JsonProperty("payee_bank_corr_account")
    private String payeeBankCorrAccount;
    private List<String> pics;
    private List<DocsDetails> docs;
    @JsonProperty("manual_payment")
    private Boolean manualPayment;
    @JsonProperty("fssp_ip")
    private String fsspIp;
    @JsonProperty("fssp_uin")
    private String fsspUin;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("archived_at")
    private String archivedAt;
    @JsonProperty("best_match_car")
    private CarDetails bestMatchCar;

}
