package me.guillaume.chuck_facts.adapters.api;

import me.guillaume.chuck_facts.application.UsersService;
import me.guillaume.chuck_facts.infrastructure.persistence.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.List.of;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class UsersControllerTest {

    private UsersService usersService;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.usersService = mock(UsersService.class);
        this.mockMvc = standaloneSetup(new UsersController()).build();
    }

    @Test
    public void shouldPippoTwice() throws Exception {

        when(usersService.users())
                .thenReturn(of(new Users("pipo-1", "pipoMdp", "pipo@mail.com"), new Users("pipo-2", "pipoMdp2", "pipo2@mail.com")));

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().string("[\"pipo-1\",\"pipo-2\"]"));
    }
}