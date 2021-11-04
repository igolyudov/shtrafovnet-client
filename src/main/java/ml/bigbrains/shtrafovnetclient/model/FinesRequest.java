package ml.bigbrains.shtrafovnetclient.model;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class FinesRequest implements GenericRequest {
    private String requestUrl = "v3/companies/{company_id}/fines";
    private Long companyId;

    private List<String> units;
    private List<Long> cars;
    private List<Long> drivers;
    private List<String> uins;

//  orgs enum:
//    org_unknown: неизвестно
//    gibdd: ГИБДД
//    ampp: АМПП
//    madi: МАДИ
//    fssp: ФССП
//    rostransnadzor: Ространснадзор (платон)
//    parking: Администраторы парковок, кроме москвы
    private List<String> orgs;

//  payment_statuses enum:
//    unknown: неизвестен/уточняется
//    nopaid: неоплачен
//    partpaid: частично оплачен
//    overpaid: переплачен
//    prepaid: предоплачен (есть сведения о попытке оплаты, но оплата ещё не дошла)
//    paid: оплачен
//    canceled: отменён/аннулирован
//    replaced: начисление заменено на новое. Ставится, когда ГИС ГМП перестаёт отвечать на запрос информации по старому УИНу и принудительно перенаправляет на новый, выписанный ФССП. Это происходит, когда штраф долго не оплачивается и администратор начисления жалуется на это приставам. По объяснению от ФССП старый штраф больше не подлежит оплате и нужно оплачивать новый. По нашему опыту если по реквизитам старого штрафа была произведена оплата, то это отразится на новом штрафе, у него уменьшится сумма или он отменится, но это происходит с очень большой задержкой, иногда в месяц
//    not_found: начисление не найдено в ГИС ГМП. Некоторые администраторы начислений долго передают информацию о штрафе в ГИС ГМП, поэтому есть ситуации, когда штраф есть например в базе МАДИ/АМПП, но его нет в ГИС ГМП
    private List<String> paymentStatuses;
    private List<String> sts;
    private List<String> grz;
    private List<String> rawid;
    private List<String> vu;

//  docs enum:
//    sts: Свидетельство о регистрации транспортного средства в органах Министерства внутренних дел Российской Федерации
//    vu: Водительское удостоверение
//    grz: Государственный регистрационный знак ТС
//    rawid: Идентификатор плательщика в формате СМЭВ2. Если ИП, то формат 4+INN. Если компания, то формат 2+INN+KPP
//    inn: ИНН Физлица
//    passport: Паспорт гражданина Российской Федерации
//    snils: CНИЛС
//    ip: Исполнительное производство
//    proof_of_born: Свидетельство органов ЗАГС, органа исполнительной власти или органа местного самоуправления о рождении гражданина
//    allower_to_temporary_live: Разрешение на временное проживание (для лиц без гражданства)
//    allower_to_wearing_hunter_weapon: Разрешение на хранение и ношение охотничьего оружия
//    army_ticket: Военный билет военнослужащего
//    certificate_aue: Справка об освобождении из мест лишения свободы
//    certificate_of_consideration: Свидетельство о рассмотрении ходатайства по существу
//    escaper_identy: Удостоверение беженца
//    hunter_ticket: Охотничий билет
//    international_passport: Паспорт гражданина Российской Федерации, являющийся основным документом, удостоверяющим личность гражданина Российской Федерации за пределами территории Российской Федерации, в том числе содержащий электронный носитель информации
//    migration_card: Миграционная карта
//    mobile_phone: Номер мобильного телефона
//    passport_of_aquaman: Паспорт моряка (удостоверение личности моряка)
//    passport_of_soilder: Удостоверение личности военнослужащего
//    passport_of_stranger: Паспорт иностранного гражданина либо иной документ, установленный федеральным законом или признаваемый в соответствии с международным договором Российской Федерации в качестве документа, удостоверяющего личность иностранного гражданина
//    russian_identy: Удостоверение личности гражданина Российской Федерации
//    temporary_russian_identy: Временное удостоверение личности гражданина Российской Федерации
//    temporary_shelter_identy: Свидетельство о предоставлении временного убежища на территории Российской Федерации
//    ussr_passport: Паспорт гражданина СССР
//    view_of_home: Вид на жительство
//    legal_inn: ИНН юр.лица в случае, когда кпп неизвестен
    private List<String> docs;
    private String search;
    private Boolean onlyArchived;
    private Boolean discountAvailable;
    private Boolean paymentExpired;
    private Boolean photosAvailable;
    private String billStarted; //YYYY-MM-DD
    private String billEnded; //YYYY-MM-DD
    private String createStarted;
    private String createEnded;
    private String updateStarted;
    private String updateEnded;

// linked_with and not_linked_with enum:
//    linked_cars: с машинами. В списке документов штрафа есть sts или grz, совпадающий с какой либо машиной в личном кабинете.
//    linked_owners: с собственниками. В списке документов штрафа есть rawid, совпадающий с одним из компаний-владельцев в личном кабинете.
//    linked_drivers: с водителями. В списке документов штрафа есть vu, совпадающий с одним из водителей в личном кабинете.
    private List<String> linkedWith;
    private List<String> notLinkedWith;

    private Boolean manualPayment;
    private String orderBy;
    private Integer limit;
    private Integer offset;
// набор полей или best_match_car - добавить в ответ связанную машину
    private List<String> with;

    public FinesRequest(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String getRequestUrl()
    {
        return requestUrl.replaceAll("\\{company_id\\}",Long.toString(companyId));
    }

    public Map<String,String> getParams()
    {
        Map<String,String> map = new HashMap<>();
        if(units!=null && !units.isEmpty())
            map.put("cond.units", String.join(",", units));
        if(cars!=null && !cars.isEmpty())
            map.put("cond.cars",cars.stream().map(String::valueOf).collect(Collectors.joining(",")));
        if(drivers!=null && !drivers.isEmpty())
            map.put("cond.drivers",drivers.stream().map(String::valueOf).collect(Collectors.joining(",")));
        if(uins!=null && !uins.isEmpty())
            map.put("cond.uins",String.join(",",uins));
        if(orgs!=null && !orgs.isEmpty())
            map.put("cond.orgs",String.join(",",orgs));
        if(paymentStatuses!=null && !paymentStatuses.isEmpty())
            map.put("cond.payment_statuses",String.join(",",paymentStatuses));
        if(sts!=null && !sts.isEmpty())
            map.put("cond.sts",String.join(",",sts));
        if(grz!=null && !grz.isEmpty())
            map.put("cond.grz",String.join(",",grz));
        if(rawid!=null && !rawid.isEmpty())
            map.put("cond.rawid",String.join(",",rawid));
        if(vu!=null && !vu.isEmpty())
            map.put("cond.vu",String.join(",",vu));
        if(docs!=null && !docs.isEmpty())
            map.put("cond.docs",String.join(",",docs));
        if(search!=null && !search.equals(""))
            map.put("cond.search",search);
        if(onlyArchived!=null)
            map.put("cond.only_archived", Boolean.toString(onlyArchived));
        if(discountAvailable!=null)
            map.put("cond.discount_available", Boolean.toString(discountAvailable));
        if(paymentExpired!=null)
            map.put("cond.payment_expired", Boolean.toString(paymentExpired));
        if(photosAvailable!=null)
            map.put("cond.photos_available", Boolean.toString(photosAvailable));
        if(billStarted!=null && !billStarted.equals(""))
            map.put("cond.bill_started",billStarted);
        if(billEnded!=null && !billEnded.equals(""))
            map.put("cond.bill_ended",billEnded);
        if(createStarted!=null && !createStarted.equals(""))
            map.put("cond.create_started",createStarted);
        if(createEnded!=null && !createEnded.equals(""))
            map.put("cond.create_ended",createEnded);
        if(updateStarted!=null && !updateStarted.equals(""))
            map.put("cond.update_started",updateStarted);
        if(updateEnded!=null && !updateEnded.equals(""))
            map.put("cond.update_ended",updateEnded);
        if(linkedWith!=null && !linkedWith.isEmpty())
            map.put("cond.linked_with",String.join(",",linkedWith));
        if(notLinkedWith!=null && !notLinkedWith.isEmpty())
            map.put("cond.not_linked_with",String.join(",",notLinkedWith));
        if(manualPayment!=null)
            map.put("cond.manual_payment", Boolean.toString(manualPayment));
        if(orderBy!=null && !orderBy.equals(""))
            map.put("order_by",orderBy);
        if(limit!=null)
            map.put("limit",Integer.toString(limit));
        if(offset!=null)
            map.put("offset",Integer.toString(offset));
        if(with!=null && !with.isEmpty())
            map.put("with",String.join(",",with));
        return map;
    }
}
