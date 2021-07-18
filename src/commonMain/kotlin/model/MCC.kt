package model

//Merchant Category Codes fetched from https://stripe.com/docs/issuing/categories
enum class MCC(val value : Int) {
     AcRefrigerationRepair(7623),
     AccountingBookkeepingServices(8931),
     AdvertisingServices(7311),
     AgriculturalCooperative(763),
     AirlinesAirCarriers(4511),
     AirportsFlyingFields(4582),
     AmbulanceServices(4119),
     AmusementParksCarnivals(7996),
     AntiqueReproductions(5937),
     AntiqueShops(5932),
     Aquariums(7998),
     ArchitecturalSurveyingServices(8911),
     ArtDealersAndGalleries(5971),
     ArtistsSupplyAndCraftShops(5970),
     AutoBodyRepairShops(7531),
     AutoPaintShops(7535),
     AutoServiceShops(7538),
     AutoAndHomeSupplyStores(5531),
     AutomatedCashDisburse(6011),
     AutomatedFuelDispensers(5542),
     AutomobileAssociations(8675),
     AutomotivePartsAndAccessoriesStores(5533),
     AutomotiveTireStores(5532),
     BailAndBondPayments(9223),
     Bakeries(5462),
     BandsOrchestras(7929),
     BarberAndBeautyShops(7230),
     BettingCasinoGambling(7995),
     BicycleShops(5940),
     BilliardPoolEstablishments(7932),
     BoatDealers(5551),
     BoatRentalsAndLeases(4457),
     BookStores(5942),
     BooksPeriodicalsAndNewspapers(5192),
     BowlingAlleys(7933),
     BusLines(4131),
     BusinessSecretarialSchools(8244),
     BuyingShoppingServices(7278),
     CableSatelliteAndOtherPayTelevisionAndRadio(4899),
     CameraAndPhotographicSupplyStores(5946),
     CandyNutAndConfectioneryStores(5441),
     CarRentalAgencies(7512),
     CarWashes(7542),
     CarAndTruckDealersNewUsed(5511),
     CarAndTruckDealersUsedOnly(5521),
     CarpentryServices(1750),
     CarpetUpholsteryCleaning(7217),
     Caterers(5811),
     CharitableAndSocialServiceOrganizationsFundraising(8398),
     ChemicalsAndAlliedProducts(5169),
     ChildCareServices(8351),
     ChildrensAndInfantsWearStores(5641),
     ChiropodistsPodiatrists(8049),
     Chiropractors(8041),
     CigarStoresAndStands(5993),
     CivicSocialFraternalAssociations(8641),
     CleaningAndMaintenance(7349),
     ClothingRental(7296),
     CollegesUniversities(8220),
     CommercialEquipment(5046),
     CommercialFootwear(5139),
     CommercialPhotographyArtAndGraphics(7333),
     CommuterTransportAndFerries(4111),
     ComputerNetworkServices(4816),
     ComputerProgramming(7372),
     ComputerRepair(7379),
     ComputerSoftwareStores(5734),
     ComputersPeripheralsAndSoftware(5045),
     ConcreteWorkServices(1771),
     ConstructionMaterials(5039),
     ConsultingPublicRelations(7392),
     CorrespondenceSchools(8241),
     CosmeticStores(5977),
     CounselingServices(7277),
     CountryClubs(7997),
     CourierServices(4215),
     CourtCosts(9211),
     CreditReportingAgencies(7321),
     CruiseLines(4411),
     DairyProductsStores(5451),
     DanceHallStudiosSchools(7911),
     DatingEscortServices(7273),
     DentistsOrthodontists(8021),
     DepartmentStores(5311),
     DetectiveAgencies(7393),
     DigitalGoodsMedia(5815),
     DigitalGoodsApplications(5817),
     DigitalGoodsGames(5816),
     DigitalGoodsLargeVolume(5818),
     DirectMarketingCatalogMerchant(5964),
     DirectMarketingCombinationCatalogAndRetailMerchant(5965),
     DirectMarketingInboundTelemarketing(5967),
     DirectMarketingInsuranceServices(5960),
     DirectMarketingOther(5969),
     DirectMarketingOutboundTelemarketing(5966),
     DirectMarketingSubscription(5968),
     DirectMarketingTravel(5962),
     DiscountStores(5310),
     Doctors(8011),
     DoorToDoorSales(5963),
     DraperyWindowCoveringAndUpholsteryStores(5714),
     DrinkingPlaces(5813),
     DrugStoresAndPharmacies(5912),
     DrugsDrugProprietariesAndDruggistSundries(5122),
     DryCleaners(7216),
     DurableGoods(5099),
     DutyFreeStores(5309),
     EatingPlacesRestaurants(5812),
     EducationalServices(8299),
     ElectricRazorStores(5997),
     ElectricalPartsAndEquipment(5065),
     ElectricalServices(1731),
     ElectronicsRepairShops(7622),
     ElectronicsStores(5732),
     ElementarySecondarySchools(8211),
     EmploymentTempAgencies(7361),
     EquipmentRental(7394),
     ExterminatingServices(7342),
     FamilyClothingStores(5651),
     FastFoodRestaurants(5814),
     FinancialInstitutions(6012),
     FinesGovernmentAdministrativeEntities(9222),
     FireplaceFireplaceScreensAndAccessoriesStores(5718),
     FloorCoveringStores(5713),
     Florists(5992),
     FloristsSuppliesNurseryStockAndFlowers(5193),
     FreezerAndLockerMeatProvisioners(5422),
     FuelDealersNonAutomotive(5983),
     FuneralServicesCrematories(7261),
     FurnitureRepairRefinishing(7641),
     FurnitureHomeFurnishingsAndEquipmentStoresExceptAppliances(5712),
     FurriersAndFurShops(5681),
     GeneralServices(1520),
     GiftCardNoveltyAndSouvenirShops(5947),
     GlassPaintAndWallpaperStores(5231),
     GlasswareCrystalStores(5950),
     GolfCoursesPublic(7992),
     GovernmentServices(9399),
     GroceryStoresSupermarkets(5411),
     HardwareStores(5251),
     HardwareEquipmentAndSupplies(5072),
     HealthAndBeautySpas(7298),
     HearingAidsSalesAndSupplies(5975),
     HeatingPlumbingAC(1711),
     HobbyToyAndGameShops(5945),
     HomeSupplyWarehouseStores(5200),
     Hospitals(8062),
     HotelsMotelsAndResorts(7011),
     HouseholdApplianceStores(5722),
     IndustrialSupplies(5085),
     InformationRetrievalServices(7375),
     InsuranceDefault(6399),
     InsuranceUnderwritingPremiums(6300),
     IntraCompanyPurchases(9950),
     JewelryStoresWatchesClocksAndSilverwareStores(5944),
     LandscapingServices(780),
     Laundries(7211),
     LaundryCleaningServices(7210),
     LegalServicesAttorneys(8111),
     LuggageAndLeatherGoodsStores(5948),
     LumberBuildingMaterialsStores(5211),
     ManualCashDisburse(6010),
     MarinasServiceAndSupplies(4468),
     MasonryStoneworkAndPlaster(1740),
     MassageParlors(7297),
     MedicalServices(8099),
     MedicalAndDentalLabs(8071),
     MedicalDentalOphthalmicAndHospitalEquipmentAndSupplies(5047),
     MembershipOrganizations(8699),
     MensAndBoysClothingAndAccessoriesStores(5611),
     MensWomensClothingStores(5691),
     MetalServiceCenters(5051),
     MiscellaneousApparelAndAccessoryShops(5699),
     MiscellaneousAutoDealers(5599),
     MiscellaneousBusinessServices(7399),
     MiscellaneousFoodStores(5499),
     MiscellaneousGeneralMerchandise(5399),
     MiscellaneousGeneralServices(7299),
     MiscellaneousHomeFurnishingSpecialtyStores(5719),
     MiscellaneousPublishingAndPrinting(2741),
     MiscellaneousRecreationServices(7999),
     MiscellaneousRepairShops(7699),
     MiscellaneousSpecialtyRetail(5999),
     MobileHomeDealers(5271),
     MotionPictureTheaters(7832),
     MotorFreightCarriersAndTrucking(4214),
     MotorHomesDealers(5592),
     MotorVehicleSuppliesAndNewParts(5013),
     MotorcycleShopsAndDealers(5571),
     MotorcycleShopsDealers(5561),
     MusicStoresMusicalInstrumentsPianosAndSheetMusic(5733),
     NewsDealersAndNewsstands(5994),
     NonFiMoneyOrders(6051),
     NonFiStoredValueCardPurchaseLoad(6540),
     NondurableGoods(5199),
     NurseriesLawnAndGardenSupplyStores(5261),
     NursingPersonalCare(8050),
     OfficeAndCommercialFurniture(5021),
     OpticiansEyeglasses(8043),
     OptometristsOphthalmologist(8042),
     OrthopedicGoodsProstheticDevices(5976),
     Osteopaths(8031),
     PackageStoresBeerWineAndLiquor(5921),
     PaintsVarnishesAndSupplies(5198),
     ParkingLotsGarages(7523),
     PassengerRailways(4112),
     PawnShops(5933),
     PetShopsPetFoodAndSupplies(5995),
     PetroleumAndPetroleumProducts(5172),
     PhotoDeveloping(7395),
     PhotographicStudios(7221),
     PhotographicPhotocopyMicrofilmEquipmentAndSupplies(5044),
     PictureVideoProduction(7829),
     PieceGoodsNotionsAndOtherDryGoods(5131),
     PlumbingHeatingEquipmentAndSupplies(5074),
     PoliticalOrganizations(8651),
     PostalServicesGovernmentOnly(9402),
     PreciousStonesAndMetalsWatchesAndJewelry(5094),
     ProfessionalServices(8999),
     PublicWarehousingAndStorage(4225),
     QuickCopyReproAndBlueprint(7338),
     Railroads(4011),
     RealEstateAgentsAndManagersRentals(6513),
     RecordStores(5735),
     RecreationalVehicleRentals(7519),
     ReligiousGoodsStores(5973),
     ReligiousOrganizations(8661),
     RoofingSidingSheetMetal(1761),
     SecretarialSupportServices(7339),
     SecurityBrokersDealers(6211),
     ServiceStations(5541),
     SewingNeedleworkFabricAndPieceGoodsStores(5949),
     ShoeRepairHatCleaning(7251),
     ShoeStores(5661),
     SmallApplianceRepair(7629),
     SnowmobileDealers(5598),
     SpecialTradeServices(1799),
     SpecialtyCleaning(2842),
     SportingGoodsStores(5941),
     SportingRecreationCamps(7032),
     SportsClubsFields(7941),
     SportsAndRidingApparelStores(5655),
     StampAndCoinStores(5972),
     StationaryOfficeSuppliesPrintingAndWritingPaper(5111),
     StationeryStoresOfficeAndSchoolSupplyStores(5943),
     SwimmingPoolsSales(5996),
     TUiTravelGermany(4723),
     TailorsAlterations(5697),
     TaxPaymentsGovernmentAgencies(9311),
     TaxPreparationServices(7276),
     TaxicabsLimousines(4121),
     TelecommunicationEquipmentAndTelephoneSales(4812),
     TelecommunicationServices(4814),
     TelegraphServices(4821),
     TentAndAwningShops(5998),
     TestingLaboratories(8734),
     TheatricalTicketAgencies(7922),
     Timeshares(7012),
     TireRetreadingAndRepair(7534),
     TollsBridgeFees(4784),
     TouristAttractionsAndExhibits(7991),
     TowingServices(7549),
     TrailerParksCampgrounds(7033),
     TransportationServices(4789),
     TravelAgenciesTourOperators(4722),
     TruckStopIteration(7511),
     TruckUtilityTrailerRentals(7513),
     TypesettingPlateMakingAndRelatedServices(2791),
     TypewriterStores(5978),
     USFederalGovernmentAgenciesOrDepartments(9405),
     UniformsCommercialClothing(5137),
     UsedMerchandiseAndSecondhandStores(5931),
     Utilities(4900),
     VarietyStores(5331),
     VeterinaryServices(742),
     VideoAmusementGameSupplies(7993),
     VideoGameArcades(7994),
     VideoTapeRentalStores(7841),
     VocationalTradeSchools(8249),
     WatchJewelryRepair(7631),
     WeldingRepair(7692),
     WholesaleClubs(5300),
     WigAndToupeeStores(5698),
     WiresMoneyOrders(4829),
     WomensAccessoryAndSpecialtyShops(5631),
     WomensReadyToWearStores(5621),
     WreckingAndSalvageYards(5935)
}