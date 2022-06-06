package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName

data class Product (

    @SerializedName("id"                               ) var id                           : String?               = null,
    @SerializedName("site_id"                          ) var siteId                       : String?               = null,
    @SerializedName("title"                            ) var title                        : String?               = null,
    @SerializedName("subtitle"                         ) var subtitle                     : String?               = null,
    @SerializedName("seller_id"                        ) var sellerId                     : Int?                  = null,
    @SerializedName("category_id"                      ) var categoryId                   : String?               = null,
    @SerializedName("official_store_id"                ) var officialStoreId              : String?               = null,
    @SerializedName("price"                            ) var price                        : Double?                  = null,
    @SerializedName("base_price"                       ) var basePrice                    : Double?                  = null,
    @SerializedName("original_price"                   ) var originalPrice                : String?               = null,
    @SerializedName("currency_id"                      ) var currencyId                   : String?               = null,
    @SerializedName("initial_quantity"                 ) var initialQuantity              : Int?                  = null,
    @SerializedName("available_quantity"               ) var availableQuantity            : Int?                  = null,
    @SerializedName("sold_quantity"                    ) var soldQuantity                 : Int?                  = null,
    @SerializedName("sale_terms"                       ) var saleTerms                    : ArrayList<SaleTerms>     = arrayListOf(),
    @SerializedName("buying_mode"                      ) var buyingMode                   : String?               = null,
    @SerializedName("listing_type_id"                  ) var listingTypeId                : String?               = null,
    @SerializedName("start_time"                       ) var startTime                    : String?               = null,
    @SerializedName("historical_start_time"            ) var historicalStartTime          : String?               = null,
    @SerializedName("stop_time"                        ) var stopTime                     : String?               = null,
    @SerializedName("condition"                        ) var condition                    : String?               = null,
    @SerializedName("permalink"                        ) var permalink                    : String?               = null,
    @SerializedName("thumbnail_id"                     ) var thumbnailId                  : String?               = null,
    @SerializedName("thumbnail"                        ) var thumbnail                    : String?               = null,
    @SerializedName("secure_thumbnail"                 ) var secureThumbnail              : String?               = null,
    @SerializedName("pictures"                         ) var pictures                     : ArrayList<Pictures>   = arrayListOf(),
    @SerializedName("video_id"                         ) var videoId                      : String?               = null,
    @SerializedName("descriptions"                     ) var descriptions                 : ArrayList<String>     = arrayListOf(),
    @SerializedName("accepts_mercadopago"              ) var acceptsMercadopago           : Boolean?              = null,
    @SerializedName("non_mercado_pago_payment_methods" ) var nonMercadoPagoPaymentMethods : ArrayList<String>     = arrayListOf(),
    @SerializedName("shipping"                         ) var shipping                     : Shipping?             = Shipping(),
    @SerializedName("international_delivery_mode"      ) var internationalDeliveryMode    : String?               = null,
    @SerializedName("seller_address"                   ) var sellerAddress                : SellerAddress?        = SellerAddress(),
    @SerializedName("seller_contact"                   ) var sellerContact                : String?               = null,
    @SerializedName("coverage_areas"                   ) var coverageAreas                : ArrayList<String>     = arrayListOf(),
    @SerializedName("attributes"                       ) var attributes                   : ArrayList<Attributes> = arrayListOf(),
    @SerializedName("warnings"                         ) var warnings                     : ArrayList<String>     = arrayListOf(),
    @SerializedName("listing_source"                   ) var listingSource                : String?               = null,
    @SerializedName("variations"                       ) var variations                   : ArrayList<Variations> = arrayListOf(),
    @SerializedName("status"                           ) var status                       : String?               = null,
    @SerializedName("sub_status"                       ) var subStatus                    : ArrayList<String>     = arrayListOf(),
    @SerializedName("tags"                             ) var tags                         : ArrayList<String>     = arrayListOf(),
    @SerializedName("warranty"                         ) var warranty                     : String?               = null,
    @SerializedName("catalog_product_id"               ) var catalogProductId             : String?               = null,
    @SerializedName("domain_id"                        ) var domainId                     : String?               = null,
    @SerializedName("parent_item_id"                   ) var parentItemId                 : String?               = null,
    @SerializedName("differential_pricing"             ) var differentialPricing          : String?               = null,
    @SerializedName("deal_ids"                         ) var dealIds                      : ArrayList<String>     = arrayListOf(),
    @SerializedName("automatic_relist"                 ) var automaticRelist              : Boolean?              = null,
    @SerializedName("date_created"                     ) var dateCreated                  : String?               = null,
    @SerializedName("last_updated"                     ) var lastUpdated                  : String?               = null,
    @SerializedName("total_listing_fee"                ) var totalListingFee              : String?               = null,
    @SerializedName("health"                           ) var health                       : Double?               = null,
    @SerializedName("catalog_listing"                  ) var catalogListing               : Boolean?              = null,
    @SerializedName("channels"                         ) var channels                     : ArrayList<String>     = arrayListOf(),
    @SerializedName("bundle"                           ) var bundle                       : String?               = null

)