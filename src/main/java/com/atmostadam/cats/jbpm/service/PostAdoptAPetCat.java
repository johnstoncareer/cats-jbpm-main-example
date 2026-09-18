package com.atmostadam.cats.jbpm.service;

import com.atmostadam.cats.api.configuration.CatWebClientProperties;
import com.atmostadam.cats.api.model.Cat;
import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.atmostadam.cats.api.service.CatService;
import com.atmostadam.cats.api.service.CatSpringBeanServiceNames;
import com.atmostadam.cats.framework.model.adoptapet.AdoptAPetRequest;
import com.atmostadam.cats.framework.model.adoptapet.LimitedPetDetails;
import com.atmostadam.cats.framework.model.adoptapet.LimitedPetImage;
import com.atmostadam.cats.framework.rest.CatWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service(CatSpringBeanServiceNames.POST_ADOPT_A_PET_CAT)
public class PostAdoptAPetCat implements CatService {
    @Autowired
    private CatWebClient client;

    @Autowired
    @Qualifier("CatWebClientPropertiesAdoptAPet")
    private CatWebClientProperties properties;

    @Override
    public ResponseEntity<CatResponse> invoke(String requestId, CatRequest request) {
        LimitedPetImage images = new LimitedPetImage()
                .thumbnail_url(null)
                .thumbnail_width(null)
                .thumbnail_height(null)
                .original_url(null)
                .original_width(null)
                .original_height(null);

        // This API only supports a single cat and all validation should be done on inbound rest resource.
        Cat cat = request.getCats().get(0);
        LimitedPetDetails pet = new LimitedPetDetails()
                .primary_breed(cat.getBreed())
                .shelter_name(null)
                .species("felis domesticus")
                .act_quickly(null)
                .adoption_process(null)
                .addr_city(null)
                .addr_line_1(null)
                .addr_line_2(null)
                .addr_postal_code(null)
                .addr_state_code(null)
                .addr_country_code(null)
                .age(cat.getName())
                .areas_served(null)
                .automap(null)
                .color(cat.getPrimaryColor())
                .contact_person(null)
                .declawed(String.valueOf(cat.isDeclawed()))
                .description(null)
                .donation_url(null)
                .email(null)
                .fax_area_code(null)
                .fax_number(null)
                .good_with_cats(cat.isGoodWithOtherPets())
                .good_with_dogs(null)
                .good_with_kids(cat.isGoodWithKids())
                .good_with_birds(null)
                .good_with_small_animals(null)
                .hair_length(null)
                .housetrained(null)
                .pet_code(null)
                .pet_id(null)
                .pet_name(cat.getName())
                .phone_area_code(null)
                .phone_extension(null)
                .phone_number(null)
                .purebred(cat.isPurebread())
                .secondary_breed(null)
                .sex(cat.getSex())
                .shelter_id(null)
                .shelter_desc(null)
                .shelter_driving_dir(null)
                .shots_current(null)
                .size(null)
                .spayed_neutered(cat.isNeutered())
                .special_needs(null)
                .website_url(null)
                .images(images)
                .bonded_to(null)
                .experienced_adopter(null)
                .rideable(null)
                .family_label(null);

        AdoptAPetRequest adoptAPetRequest = new AdoptAPetRequest()
                .action("ADD")
                .pet(pet);
        return client.invoke(properties, requestId, adoptAPetRequest);
    }
}
