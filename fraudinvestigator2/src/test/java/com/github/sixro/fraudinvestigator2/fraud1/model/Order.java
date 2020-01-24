package com.github.sixro.fraudinvestigator2.fraud1.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.joda.time.DateTime;
import org.joda.time.Seconds;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Date;


/**
 * Classe che rappresenta ordini da processare per il fraud investigator.<br/>
 * Gli attributi di questa classe rappresentano elementi che vengono usati nelle regole
 * MVEL eseguite dalla classe {@link RuleExecutor}, per questo non possono mai essere
 * nulli, ma hanno dei valori di default dipendenti dal tipo di attributo che si
 * considera, ovvero per le stringhe il default &egrave; stringa vuota, per le liste
 * &egrave; lista vuota e per i numeri &egrave; zero (per i valori booleani il valore di
 * default di java &egrave; <code>false</code>).<br/>
 * Una eccezione &egrave; rappresentata dal valore di default dell'attributo <code>
 * bookingToDepartureInterval</code>, il cui valore di default &egrave; -1, visto che 0
 * &egrave; un valore valido per questo attributo (nel caso di prenotazione acquistata
 * nello stesso giorno della partenza, infatti l'attributo in questione rappresenta
 * proprio il numero di giorni che separano la creazione della prenotazione dalla partenza
 * del volo, questo &egrave; un attributo valorizzato solo nel caso la prenotazione
 * preveda appunto un volo).<br/>
 * Attenzione si deve porre agli attributi <code>contactFirstName</code> e <code>
 * contactLastName</code>, sono stringhe, perch&egrave; cos&igrave; le riceviamo da
 * volagratis, ma vengono restituiti come liste, perch&egrave; nel caso di doppio nome o
 * cognome preferiamo lavorare con le liste nelle regole.<br/>
 * In genere le stringhe vengono restituite "toUpperCase" perch%egrave; nelle regole non
 * vogliamo effettuare controlli "case sensitive", tuttavia invitiamo ad effettuare
 * verifiche, questa regola potrebbe avere delle eccezioni.<br/>
 * Un attributo di natura diversa &egrave; lo <code>score</code>, esso rappresenta infatti
 * la valutazione conclusiva del fraudinvestigator sulla richiesta pervenuta ed &egrave;
 * la somma degli score ottenuti dall'esecuzione delle singole regole (si veda la classe
 * {@link RuleExecutor}) appartenenti alla catena che &egrave; stata applicata.<br/>
 * <br/>
 *
 * <p>Su ogni attributo, sebbene siano <code>private</code>, &egrave; stato aggiunto un
 * javadoc che ne specifica il significato.</p>
 */
public class Order implements Serializable
{
  private static final long serialVersionUID = -5946721202101616570L;

  /**
   * La lista dei codici degli aeroporti sono recuperati dai flights contenuti nel
   * booking, da ogni flight si recuperano i legs da cui si estrapolano i codici degli
   * aeroporti di partenza e di arrivo.
   */
  private ExtendedList<String> airportsCountryCodes = new ExtendedList<String>();

  /**
   * Importo dell'ordine (ovvero, nel caso delle simulazioni da backoffice, il
   * booking.getCustomerCost() oppure il paymentInfo.getTransactionAmount() nel caso di
   * volagratis (in quest'ultimo caso abbiamo il costo della prenotazione incrementato
   * delle commissioni, mentre il customerCost non &egrave; ancora disponibile o non
   * &egrave; attendibile).)
   */
  private BigDecimal orderAmount = BigDecimal.ZERO.setScale(2, RoundingMode.UP);

  /**
   * Lo score della prenotazione, rappresenta la valutazione effettuata dal
   * fraudinvestigator sulla richiesta pervenuta ed &egrave; calcolato come somma degli
   * score che sono conseguenza dell'esecuzione delle singole regole che compongono la
   * catena che &egrave; stata applicata.
   */
  private BigDecimal score = BigDecimal.ZERO.setScale(2, RoundingMode.UP);

  /** Lista dei passeggeri */
  private ExtendedList<Passenger> passengers = new ExtendedList<Passenger>();

  /**
   * Questa lista &egrave; vuota ogni volta che si considerino prenotazioni che non
   * includano dei voli, quando non vuota contiene 2 valori, l'aeroporto di partenza e
   * quello di arrivo del primo leg del primo flight del booking.
   */
  private ExtendedList<Airport> airports = new ExtendedList<Airport>();

  /**
   * Country code dell'aeroporto di partenza, ovvero il departureAirport del firstLeg del
   * firstFlight del booking
   */
  private String departureAirportCountryCode = "";

  /**
   * Country code dell'aeroporto d'arrivo, ovvero del arrivalAirport del firstLeg del
   * firstFlight del booking
   */
  private String arrivalAirportCountryCode = "";
  private EFraudEnvironment eFraudEnvironment;
  private final Counters counters = new Counters();

  /**
   * Prima parte della mail del contatto, ovvero la parte che arriva al simbolo di @
   * escluso (esempio: giovanni.giachetti@gmail.com, allora la noDomainContactEmail in
   * questo caso &egrave; giovanni.giachetti).
   */
  private String noDomainContactEmail = "";
  private MaxMindResponse maxMindResponse;

  /** &Egrave; il contactPhoneNumber2 del booking. */
  private String contactMobileNumber = "";

  private final Score scoreValues = new Score();

  /** &Egrave; il booking.getContactCountryCode() */
  private String contactCountryCode = "";

  /**
   * Intervallo in giorni tra il giorno di creazione della prenotazione e la data di
   * partenza, ottenuta dal dapartureDate del firstLeg del firtsFlight del booking (quindi
   * valorizzata solo in caso di presenza di un volo, altrimenti resta il valore di
   * default, che &egrave; -1).
   */
  private int bookingToDepartureInterval = -1;

  /** &Egrave; il booking.getContactPhoneNumber() */
  private String contactPhoneNumber = "";
  private String contactEmailDomain = "";
  private OrderReference orderReference;
  private String contactFirstName = "";
  private String contactLastName = "";

  /**
   * <code>true</code> se il contatto della prenotazione &egrave; anche un passeggero
   * (informazione recuperata direttamente dal booking, <code>
   * booking.isContactIsPassenger()</code>.
   */
  private boolean contactIsPassenger;

  /**
   * Viene valorizzato a <code>true</code> quando il sistema dell'antifrode effettua una
   * chiamata al sistema maxmind e ne riceva una risposta (<code>maxMindResponse</code>)
   * senza errori.
   */
  private boolean maxMindSuccessful;

  /**
   * Quando valorizzato a <code>true</code> indica che il lavoro dei contatori &egrave;
   * concluso, in pratica non pu&ograve; mai essere <code>false</code>, a meno che
   * un'eccezione non sia occorsa.
   */
  private boolean countersSuccessful;
  private String contactEmail = "";

  /**
   * Il numero di carta di credito (criptato) Ovviamente &egrave; valorizzato solo quando
   * si paga con carta di credito.
   */
  private String panEncrypted = "";

  /**
   * BRAND cui appartiene la carta, es. VISA, MASTERCARD, ecc. Potrebbe essere <code>
   * null</code>...
   */
  private String cardType = "";

  /** Il codice del voucher (al momento non &egrave; mai valorizzato). */
  private String voucherCode = "";

  /** Sono le note dell'utente (booking.getUserNotes()) */
  private String orderNotes = "";

  /** Lista delle idAirlines recuperate iterando sui flights del booking. */
  private ExtendedList<String> idAirlines = new ExtendedList<String>();

  private String ipAddress = "";
  private String language = "";

  /**
   * Sistema monetario di pagamento N:B: Al momento abbiamo solo Currency.EURO per
   * volagratis perch&egrave; &egrave; l'euro la valuta con cui vengono salvati gli
   * importi dei booking
   */
  private String orderCurrency;

  /**
   * Controlla se la prenotazione &egrave; una vendita diretta
   * (<code>!booking.isAllNotDirectSale()</code>), il booking per ottenere questa
   * informazione si avvale del BookingHelper che naviga i products che compongono il
   * booking.
   */
  private boolean directSale;

  /**
   * Viene recuperato dal <code>InetAddress.getLocalHost().getCanonicalHostName()</code>,
   * quindi rappresenta il nome del server di produzione che effettua la richiesta al
   * fraudinvestigator
   */
  private String server = "";

  /**
   * <code>true</code> se la prenotazione contiene dei voli
   * (<code>booking.hasBookingFlight()</code>).
   */
  private boolean hasFlights;

  /** Questo parametro al momento non &egrave; mai valorizzato. */
  private boolean hasVoucher;
  private String blackBox;

  /**
   * <code>true</code> se la prenotazione contiene almeno un treno (Un treno &egrave; un
   * bookingFlight di tipo treno!).
   */
  private boolean hasTrains;

  /** <code>true</code> se la prenotazione contiene almeno un hotel. */
  private boolean hasHotel;

  /**
   * Codice bin della carta di credito usata per l'acquisto.<br/>
   * Al momento proviene dal <code>booking.getTBinCC()</code> e non &egrave; un dato che
   * viene salvato a db.
   */
  private String bin = "";

  /** <code>true</code> se la prenotazione &egrave; un charter */
  private boolean charter;

  /** <code>true</code> se la prenotatione proviene da un'agenzia. */
  private boolean agency;

  /** Identifica il tipo di prenotazione, flight, multiproduct oppure hotel. */
  private String orderType;
  private EPaymentType paymentType;
  private String paymentCode;

  /**
   * Identificativo dell'aeroporto di partenza calcolato come <code>
   * booking.firstFlight().firstLeg().getDepartureAirport()</code>
   */
  private String idDepartureAirport;

  /**
   * Identificativo dell'aeroporto di arrivo calcolato come <code>
   * booking.firstFlight().firstLeg().getArrivalAirport()</code>
   */
  private String idArrivalAirport;

  /** <code>true</code> se la prenotazione &egrave; un volo. */
  private boolean flight;

  /** <code>true</code> se la prenotazione &egrave; un hotel. */
  private boolean hotel;

  /** <code>true</code> se la prenotazione &egrave; un viaggio. */
  private boolean multiProduct;

  /**
   * Il <code>contactPhoneCountry</code> viene recuperato dal prefisso dei numeri del
   * contatto, in particolare si cerca di recupera questo dato dal <code>
   * contactPhoneNumber</code>, ma se questo &egrave; nullo o non utilizzabile per lo
   * scopo, allora si cerca di recuperarlo dal <code>contactMobileNumber</code>. Il modo
   * come viene recuperato il <code>contactPhoneCountry</code> viene espresso nel metodo
   * <code>setPhoneNumbers</code>.
   */
  private String contactPhoneCountry = "";

  /** <code>true</code> se la prenotazione ha una macchina */
  private boolean hasCars;

  /** <code>true</code> se è presente il documento per almeno un passeggero */
  private boolean hasPassengerDocuments;

  /** secondi trascorsi dalla creazioen del booking al pagamento */
  private long bookingToPaymentInterval;

  private String idBusinessProfile;
  private OrderDate orderDate;
  private String cobranded;
  private boolean invoice;
  private String brand;
  private String uid;

  private IOvation iOvation = new IOvation();

  private String idCompanyCollect;
  private String businessProfileGroup;

  private String insuranceMode;
  
  /** Attributes to manage hotels and trains data */
  private String hotelCountry;
  private String hotelCity;
  private String trainDepartureCountry;
  private String trainDepartureCity;
  private String trainArrivalCountry;
  private String trainArrivalCity;
  private String holidaysDestination;
  private String hotelProvider;
  private String packageProvider;
  private Integer numberOfNights = new Integer(-1); // calcolare a partire da checkin e out date
  private Integer numberOfGuests = new Integer(-1);
  private Integer bookingToTrainDepartureInterval = new Integer(-1);
  private Integer bookingToHotelCheckinInterval = new Integer(-1);
  private OrderDate hotelCheckinDate;
  private OrderDate trainDepartureDate;
  private String emailDomainCountry;
  private boolean articlePresent;
  private boolean carPresent;
  private boolean paymentInInstallments;
  private String source;
  private String businessProfileFraudCluster;
  private String cardOrigin;
  private boolean moto;
  private String transactionPurpose;
  private String token;

  public Order()
  {
  }

  public synchronized void addScore(final BigDecimal score)
  {
    this.score = this.score.add(score);
  }

  public ExtendedList<Airport> getAirports()
  {
    return airports;
  }

  /**
   * La lista dei codici degli aeroporti sono recuperati dai flights contenuti nel
   * booking, da ogni flight si recuperano i legs da cui si estrapolano i codici degli
   * aeroporti di partenza e di arrivo.
   *
   * @return  lista di codici delle nazioni degli aeroporti.
   */
  public ExtendedList<String> getAirportsCountryCodes()
  {
    return airportsCountryCodes;
  }

  public String getArrivalAirportCountryCode()
  {
    return arrivalAirportCountryCode.toUpperCase();
  }

  public String getBin()
  {
    return bin;
  }

  public String getBlackBox()
  {
    return blackBox;
  }

  public int getBookingToDepartureInterval()
  {
    return bookingToDepartureInterval;
  }

  public long getBookingToPaymentInterval()
  {
    return bookingToPaymentInterval;
  }
  
  public String getBusinessProfileFraudCluster()
  {
    return businessProfileFraudCluster;
  }

  public String getBrand()
  {
    return brand;
  }

  public String getCardType()
  {
    return cardType.toUpperCase();
  }

  public String getCobranded()
  {
    return cobranded;
  }

  public String getContactCountryCode()
  {
    return contactCountryCode.toUpperCase();
  }

  public String getContactEmail()
  {
	    return contactEmail;
//	    return contactEmail.toUpperCase();
  }

  public String getContactEmailDomain()
  {
    return contactEmailDomain.toUpperCase();
  }

  public ExtendedList<String> getContactFirstName()
  {
    return new ExtendedList<String>(Arrays.asList(contactFirstName.toUpperCase().split("\\s+")));
  }

  public String getContactFullName()
  {
    return (contactLastName + " " + contactFirstName).toUpperCase();
  }

  public ExtendedList<String> getContactLastName()
  {
    return new ExtendedList<String>(Arrays.asList(contactLastName.toUpperCase().split("\\s+")));
  }

  public String getContactMobileNumber()
  {
    return contactMobileNumber;
  }

  public String getContactPhoneCountry()
  {
    return contactPhoneCountry.toUpperCase();
  }

  public String getContactPhoneNumber()
  {
    return contactPhoneNumber;
  }

  public Counters getCounters()
  {
    return counters;
  }

  public String getDepartureAirportCountryCode()
  {
    return departureAirportCountryCode.toUpperCase();
  }

  public EFraudEnvironment getEFraudEnvironment()
  {
    return eFraudEnvironment;
  }

  public String getFirstPassengerCountryCode()
  {
    if (passengers.isEmpty())
    {
      return "";
    }

    return passengers.get(0).getCountryCode().toUpperCase();
  }

  public ExtendedList<String> getFirstPassengerFirstName()
  {
    if (passengers.isEmpty())
    {
      return new ExtendedList<String>();
    }

    return new ExtendedList<String>(Arrays.asList(passengers.get(0).getFirstName().toUpperCase().split("\\s+")));
  }

  public ExtendedList<String> getFirstPassengerLastName()
  {
    if (passengers.isEmpty())
    {
      return new ExtendedList<String>();
    }

    return new ExtendedList<String>(Arrays.asList(passengers.get(0).getLastName().toUpperCase().split("\\s+")));
  }

  public String getId()
  {
    return orderReference.getOrderId();
  }

  public ExtendedList<String> getIdAirlines()
  {
    return idAirlines;
  }

  public String getIdArrivalAirport()
  {
    return idArrivalAirport;
  }

  public String getIdBusinessProfile()
  {
    return idBusinessProfile;
  }

  public String getIdCompanyCollect()
  {
    return idCompanyCollect;
  }

  public String getIdDepartureAirport()
  {
    return idDepartureAirport.toUpperCase();
  }

  public String getInsuranceMode()
  {
    return insuranceMode;
  }

  public IOvation getIOvation()
  {
    return iOvation;
  }

  public String getIpAddress()
  {
    return ipAddress;
  }

  public String getLanguage()
  {
    return language.toUpperCase();
  }

  public MaxMindResponse getMaxMindResponse()
  {
    return maxMindResponse;
  }

  public String getNoDomainContactEmail()
  {
    return noDomainContactEmail.toUpperCase();
  }
  
  public String getBusinessProfileGroup ()
  {
    return this.businessProfileGroup;
  }
  
  public void setBusinessProfileGroup (String businessProfileGroup)
  {
    this.businessProfileGroup = businessProfileGroup;
  }

  /**
   * Ritorna l'importo dell'ordine (ovvero, nel caso di vg, il booking.customerCost oppure
   * il paymentInfo.getTransactionAmount(), a seconda dei contesti.)
   *
   * @return  l'importo dell'ordine (ovvero, nel caso di vg, il booking.customerCost
   *          oppure il paymentInfo.getTransactionAmount(), a seconda dei contesti.)
   */
  public BigDecimal getOrderAmount()
  {
    return orderAmount;
  }

  public String getOrderCurrency()
  {
    return orderCurrency;
  }

  public OrderDate getOrderDate()
  {
    return orderDate;
  }

  public int getOrderDateDay()
  {
    return orderDate.getOrderDateDay();
  }

  public int getOrderDateHour()
  {
    return orderDate.getOrderDateHour();
  }

  public int getOrderDateMinute()
  {
    return orderDate.getOrderDateMinute();
  }

  public int getOrderDateMonth()
  {
    return orderDate.getOrderDateMonth();
  }

  public int getOrderDateSecond()
  {
    return orderDate.getOrderDateSecond();
  }

  public int getOrderDateYear()
  {
    return orderDate.getOrderDateYear();
  }

  public String getOrderDayName()
  {
    return orderDate.getOrderDayName();
  }

  public String getOrderNotes()
  {
    return orderNotes;
  }

  public OrderReference getOrderReference()
  {
    return orderReference;
  }

  public String getOrderType()
  {
    return orderType;
  }

  public String getPanEncrypted()
  {
    return panEncrypted;
  }

  public String getPartner()
  {
    return orderReference.getPartnerId();
  }

  public String getPartnerId()
  {
    return orderReference.getPartnerId();
  }

  public ExtendedList<Passenger> getPassengers()
  {
    return passengers;
  }

  public String getPaymentCode()
  {
    return paymentCode;
  }

  public String getPaymentMode()
  {
    return paymentType.name();
  }

  public EPaymentType getPaymentType()
  {
    return paymentType;
  }

  public BigDecimal getScore()
  {
    return score;
  }

  public Score getScoreValues()
  {
    return scoreValues;
  }

  public String getServer()
  {
    return server;
  }

  public int getTransactionNum()
  {
    return orderReference.getTransactionNum();
  }

  public String getUid()
  {
    return uid;
  }

  public String getVoucherCode()
  {
    return voucherCode;
  }

  public boolean isAgency()
  {
    return agency;
  }

  public boolean isCharter()
  {
    return charter;
  }

  public boolean isContactIsPassenger()
  {
    return contactIsPassenger;
  }

  public boolean isCountersSuccessful()
  {
    return countersSuccessful;
  }

  public boolean isDirectSale()
  {
    return directSale;
  }

  public boolean isFlight()
  {
    return flight;
  }

  public boolean isHasCars()
  {
    return hasCars;
  }

  /**
   * Questa denominazione deriva dall'uso che viene effettuato dell'order da MVEL, quindi
   * non &egrave; da modificare.
   *
   * @return
   */
  public boolean isHasFlights()
  {
    return hasFlights;
  }

  public boolean isHasHotel()
  {
    return hasHotel;
  }

  public boolean isHasPassengerDocuments()
  {
    return hasPassengerDocuments;
  }

  public boolean isHasTrains()
  {
    return hasTrains;
  }

  public boolean isHasVoucher()
  {
    return hasVoucher;
  }

  public boolean isHotel()
  {
    return hotel;
  }

  public boolean isInvoice()
  {
    return invoice;
  }

  public boolean isMaxMindSuccessful()
  {
    return maxMindSuccessful;
  }

  public boolean isMultiProduct()
  {
    return multiProduct;
  }

  public void setAgency(final boolean agency)
  {
    this.agency = agency;
  }

  public void setAirports(final ExtendedList<Airport> airports)
  {
    if ((airports != null) && !airports.isEmpty())
    {
      this.airports = airports;

      departureAirportCountryCode = airports.get(0).getCountryCode();
      idDepartureAirport = airports.get(0).getIdAirport();
    }

    if (airports.size() > 1)
    {
      arrivalAirportCountryCode = airports.get(airports.size() - 1).getCountryCode();
      idArrivalAirport = airports.get(airports.size() - 1).getIdAirport();
    }
  }

  public void setAirportsCountryCodes(final ExtendedList<String> airportsCountryCodes)
  {
    if (null != airportsCountryCodes)
    {
      this.airportsCountryCodes = airportsCountryCodes;
    }
  }

  public void setBin(final String bin)
  {
    if (null != bin)
    {
      this.bin = bin;
    }
  }

  public void setBlackBox(final String blackBox)
  {
    this.blackBox = blackBox;
  }

  public void setBookingToDepartureInterval(final int dateInterval)
  {
    bookingToDepartureInterval = dateInterval;
  }

  public void setBrand(final String brand)
  {
    this.brand = brand;
  }

  public void setBusinessProfileFraudCluster(String businessProfileFraudCluster)
  {
    this.businessProfileFraudCluster = businessProfileFraudCluster;
  }
  
  public void setCardType(final String cardType)
  {
    if (null != cardType)
    {
      this.cardType = cardType;
    }
  }

  public void setCharter(final boolean charter)
  {
    this.charter = charter;
  }

  public void setCobranded(final String cobranded)
  {
    this.cobranded = cobranded;
  }

  public void setContactCountryCode(final String contactCountryCode)
  {
    if (null != contactCountryCode)
    {
      this.contactCountryCode = contactCountryCode;
    }
  }

  public void setContactEmail(final String contactEmail)
  {
    if (null != contactEmail)
    {
      this.contactEmail = contactEmail;

      if (contactEmail.indexOf("@") >= 0)
      {
        noDomainContactEmail = contactEmail.substring(0, contactEmail.indexOf("@"));
        contactEmailDomain = contactEmail.substring(contactEmail.indexOf("@") + 1);
      }
    }
  }

  public void setContactFirstName(final String contactFirstName)
  {
    if (null != contactFirstName)
    {
      this.contactFirstName = contactFirstName;
    }
  }

  public void setContactIsPassenger(final boolean contactIsPassenger)
  {
    this.contactIsPassenger = contactIsPassenger;
  }

  public void setContactLastName(final String contactLastName)
  {
    if (null != contactLastName)
    {
      this.contactLastName = contactLastName;
    }
  }

  public void setCountersSuccessful(final boolean countersSuccessful)
  {
    this.countersSuccessful = countersSuccessful;
  }

  public void setDirectSale(final boolean directSale)
  {
    this.directSale = directSale;
  }

  public void setEFraudEnvironment(final EFraudEnvironment eFraudEnvironment)
  {
    this.eFraudEnvironment = eFraudEnvironment;
  }

  public void setFlight(final boolean flight)
  {
    this.flight = flight;
  }

  public void setHasCars(final boolean hasCars)
  {
    this.hasCars = hasCars;
  }

  public void setHasFlights(final boolean hasFlights)
  {
    this.hasFlights = hasFlights;
  }

  public void setHasHotel(final boolean hasHotel)
  {
    this.hasHotel = hasHotel;
  }

  public void setHasPassengerDocuments(final boolean hasPassengerDocuments)
  {
    this.hasPassengerDocuments = hasPassengerDocuments;
  }

  public void setHasTrains(final boolean hasTrains)
  {
    this.hasTrains = hasTrains;
  }

  public void setHasVoucher(final boolean hasVoucher)
  {
    this.hasVoucher = hasVoucher;
  }

  public void setHotel(final boolean hotel)
  {
    this.hotel = hotel;
  }

  /**
   * Passando un parametro nullo non si modifica l'attuale valore dell'attributo
   * idAirlines (ovvero passare come parametro <code>null</code> equivale a non invocare
   * questo metodo).
   *
   * @param  idAirlines
   */
  public void setIdAirlines(final ExtendedList<String> idAirlines)
  {
    if (null != idAirlines)
    {
      this.idAirlines = idAirlines;
    }
  }

  public void setIdBusinessProfile(final String idBusinessProfile)
  {
    this.idBusinessProfile = idBusinessProfile;
  }

  public void setIdCompanyCollect(final String idCompanyCollect)
  {
    this.idCompanyCollect = idCompanyCollect;

  }

  public void setInsuranceMode(String insuranceMode)
  {
    this.insuranceMode = insuranceMode;
  }

  public void setInvoice(final boolean invoice)
  {
    this.invoice = invoice;
  }

  public void setIOvation(final IOvation iOvation)
  {
    this.iOvation = iOvation;
  }

  public void setIpAddress(final String ipAddress)
  {
    if (null != ipAddress)
    {
      this.ipAddress = ipAddress;
    }
  }

  public void setLanguage(final String language)
  {
    if (null != language)
    {
      this.language = language;
    }
  }

  public void setMaxMindResponse(final MaxMindResponse maxMindResponse)
  {
    this.maxMindResponse = maxMindResponse;
  }

  public void setMaxMindSuccessful(final boolean maxMindSuccessful)
  {
    this.maxMindSuccessful = maxMindSuccessful;
  }

  public void setMultiProduct(final boolean multiProduct)
  {
    this.multiProduct = multiProduct;
  }

  public void setOrderAmount(final BigDecimal orderAmount)
  {
    if (null != orderAmount)
    {
      this.orderAmount = orderAmount;
    }
  }

  public void setOrderCurrency(final String orderCurrency)
  {
    this.orderCurrency = orderCurrency;
  }

  public void setOrderDate(final Date orderDate)
  {
    this.orderDate = new OrderDate(orderDate);
    this.bookingToPaymentInterval = calculateIntervalInSeconds(new DateTime(orderDate.getTime()), new DateTime());
  }

  protected static long calculateIntervalInSeconds(DateTime from, DateTime to)
  {
    return Seconds.secondsBetween(from, to).getSeconds();
  }

  public void setOrderNotes(final String orderNotes)
  {
    if (null != orderNotes)
    {
      this.orderNotes = orderNotes;
    }
  }

  public void setOrderReference(final OrderReference orderReference)
  {
    this.orderReference = orderReference;
  }

  public void setOrderType(final String orderType)
  {
    if (null != orderType)
    {
      this.orderType = orderType;
    }
  }

  public void setPanEncrypted(final String panEncrypted)
  {
    if (null != panEncrypted)
    {
      this.panEncrypted = panEncrypted;
    }
  }

  public void setPassengers(final ExtendedList<Passenger> passengers)
  {
    if (passengers != null)
    {
      this.passengers = passengers;
    }
  }

  public void setPaymentCode(final String paymentCode)
  {
    this.paymentCode = paymentCode;
  }

  public void setPaymentType(final String paymentType)
  {
    if (null != paymentType)
    {
      this.paymentType = EPaymentType.valueOf(paymentType.toUpperCase());
    }
  }

  /**
   * Setter per i numeri di telefono del contatto e set anche del contactPhoneCountry che
   * viene recuperato dal prefisso dei numeri passati, in particolare dal primo, ma se
   * questo &egrave; nullo o non utilizzabile per lo scopo, allora si cerca di recuperarlo
   * dal secondo numero passato. &Egrave; necessario fornire anche il language per
   * recuperare il contactPhoneCountry e il servizio che esegue l'operazione.
   *
   */
  /*
  public void setPhoneNumbers(final String contactPhoneNumber,
                              final String contactMobileNumber, final String language,
                              final CountryService countryService)
  {
    setContactPhoneNumber(contactPhoneNumber);
    setContactMobileNumber(contactMobileNumber);
    setLanguage(language);

    final String phoneInternationalPrefix = getPhoneInternationalPrefix(contactPhoneNumber,
                                                                        contactMobileNumber);
    setContactPhoneCountry(countryService.getCountryCodeByPhoneNumberPrefix(language,
                                                                            phoneInternationalPrefix));

  }
     */


  public void setServer(final String server)
  {
    if (null != server)
    {
      this.server = server;
    }
  }

  public void setUid(final String uid)
  {
    this.uid = uid;
  }

  public void setVoucherCode(final String voucherCode)
  {
    if (null != voucherCode)
    {
      this.voucherCode = voucherCode;
    }
  }

  private String getPhoneInternationalPrefix(final String phoneNumber1,
                                             final String phoneNumber2)
  {
    /*
    final String phoneNumber = ((phoneNumber1 == null) || phoneNumber1.trim().equals(""))
                               ? phoneNumber2 : phoneNumber1.trim();
    final PhoneNumberUtil numUtils = new PhoneNumberUtil(phoneNumber);
    numUtils.splitPhone();

    return numUtils.getPhoneInternationalPrefix();

     */
    return "39";
  }

  private void setContactMobileNumber(final String contactMobileNumber)
  {
    if (null != contactMobileNumber)
    {
      this.contactMobileNumber = contactMobileNumber;
    }
  }

  private void setContactPhoneCountry(final String phoneCountry)
  {
    if (phoneCountry != null)
    {
      contactPhoneCountry = phoneCountry;
    }
  }

  private void setContactPhoneNumber(final String contactPhoneNumber)
  {
    if (null != contactPhoneNumber)
    {
      this.contactPhoneNumber = contactPhoneNumber;
    }
  }

  public String getHotelCountry ()
  {
    return hotelCountry;
  }

  public void setHotelCountry (String hotelCountry)
  {
    this.hotelCountry = hotelCountry;
  }

  public String getHotelCity ()
  {
    return hotelCity;
  }

  public void setHotelCity (String hotelCity)
  {
    this.hotelCity = hotelCity;
  }

  public String getTrainDepartureCountry ()
  {
    return trainDepartureCountry;
  }

  public void setTrainDepartureCountry (String trainDepartureCountry)
  {
    this.trainDepartureCountry = trainDepartureCountry;
  }

  public String getTrainDepartureCity ()
  {
    return trainDepartureCity;
  }

  public void setTrainDepartureCity (String trainDepartureCity)
  {
    this.trainDepartureCity = trainDepartureCity;
  }

  public String getTrainArrivalCountry ()
  {
    return trainArrivalCountry;
  }

  public void setTrainArrivalCountry (String trainArrivalCountry)
  {
    this.trainArrivalCountry = trainArrivalCountry;
  }

  public String getTrainArrivalCity ()
  {
    return trainArrivalCity;
  }

  public void setTrainArrivalCity (String trainArrivalCity)
  {
    this.trainArrivalCity = trainArrivalCity;
  }

  public String getHolidaysDestination ()
  {
    return holidaysDestination;
  }

  public void setHolidaysDestination (String holidaysDestination)
  {
    this.holidaysDestination = holidaysDestination;
  }

  public String getHotelProvider ()
  {
    return hotelProvider;
  }

  public void setHotelProvider (String hotelProvider)
  {
    this.hotelProvider = hotelProvider;
  }

  public String getPackageProvider ()
  {
    return packageProvider;
  }

  public void setPackageProvider (String packageProvider)
  {
    this.packageProvider = packageProvider;
  }

  public Integer getNumberOfNights ()
  {
    return numberOfNights;
  }

  public void setNumberOfNights (Integer numberOfNights)
  {
    this.numberOfNights = numberOfNights;
  }

  public Integer getNumberOfGuests ()
  {
    return numberOfGuests;
  }

  public void setNumberOfGuests (Integer numberOfGuests)
  {
    this.numberOfGuests = numberOfGuests;
  }

  public OrderDate getHotelCheckinDate ()
  {
    return hotelCheckinDate;
  }

  public void setHotelCheckinDate (OrderDate hotelCheckinDate)
  {
    this.hotelCheckinDate = hotelCheckinDate;
  }

  public OrderDate getTrainDepartureDate ()
  {
    return trainDepartureDate;
  }

  public void setTrainDepartureDate (OrderDate trainDepartureDate)
  {
    this.trainDepartureDate = trainDepartureDate;
  }

  public String getEmailDomainCountry ()
  {
    return emailDomainCountry;
  }

  public void setEmailDomainCountry (String emailDomainCountry)
  {
    this.emailDomainCountry = emailDomainCountry;
  }

  public boolean isArticlePresent ()
  {
    return articlePresent;
  }

  public void setArticlePresent (boolean articlePresent)
  {
    this.articlePresent = articlePresent;
  }

  public boolean isCarPresent ()
  {
    return carPresent;
  }

  public void setCarPresent (boolean carPresent)
  {
    this.carPresent = carPresent;
  }

  public boolean isPaymentInInstallments ()
  {
    return paymentInInstallments;
  }

  public void setPaymentInInstallments (boolean paymentInInstallments)
  {
    this.paymentInInstallments = paymentInInstallments;
  }

  public Integer getBookingToTrainDepartureInterval ()
  {
    return bookingToTrainDepartureInterval;
  }

  public Integer getBookingToHotelCheckinInterval ()
  {
    return bookingToHotelCheckinInterval;
  }

  public void setBookingToTrainDepartureInterval (Integer bookingToTrainDepartureInterval)
  {
    this.bookingToTrainDepartureInterval = bookingToTrainDepartureInterval;
  }

  public void setBookingToHotelCheckinInterval (Integer bookingToHotelCheckinInterval)
  {
    this.bookingToHotelCheckinInterval = bookingToHotelCheckinInterval;
  }
  
  public String getSource ()
  {
    return source;
  }
  
  public void setSource (String source)
  {
    this.source = source;
  }

  public void setCardOrigin(String cardOrigin) {
    if(cardOrigin == null)
      this.cardOrigin = "";
    else
      this.cardOrigin = cardOrigin;
  }

  public String getCardOrigin() {
    return cardOrigin;
  }

  @Override
  public String toString() {
    //return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    return ReflectionToStringBuilder.toStringExclude(this, "counters", "scoreValues", "iOvation", "maxMindResponse", "panEncrypted");
  }

  public String getTransactionPurpose()
  {
    return transactionPurpose;
  }

  public void setTransactionPurpose(String transactionPurpose)
  {
    this.transactionPurpose = transactionPurpose;
  }

  public boolean isMoto()
  {
    return moto;
  }

  public void setMoto(boolean moto)
  {
    this.moto = moto;
  }

  public String getToken()
  {
    return token;
  }

  public void setToken(String token)
  {
    this.token = token;
  }
}