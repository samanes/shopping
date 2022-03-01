package io.jur.shopping.controller;

import io.jur.shopping.ShoppingListTestData;
import io.jur.shopping.service.ShoppingListService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ShoppingListController.class)
public class ShoppingListControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShoppingListService shoppingListService;

    @Test
    public void getShoppingList_test() throws Exception {
        when(shoppingListService.getShoppingListByUser(anyLong()))
                .thenReturn(ShoppingListTestData.getTestShoppingListData());
        MvcResult result = mockMvc.perform(get("/shopping-list/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(status().isOk())
                .andReturn();
        JSONAssert.assertEquals("{\"shoppingItems\":[{\"id\":1,\"name\":\"item1\",\"description\":\"item1 description\",\"price\":20,\"quantity\":1,\"subTotal\":20},{\"id\":2,\"name\":\"item2\",\"description\":\"item2 description\",\"price\":15,\"quantity\":2,\"subTotal\":30}],\"total\":50}"
                , result.getResponse().getContentAsString(), false);
    }

}
