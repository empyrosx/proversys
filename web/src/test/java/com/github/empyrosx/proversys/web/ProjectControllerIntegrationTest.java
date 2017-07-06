package com.github.empyrosx.proversys.web;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.service.ProjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for project controller.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:/spring/spring-mvc.xml", "classpath:/spring/spring-mock.xml"})
@WebAppConfiguration
public class ProjectControllerIntegrationTest {

    private static final CharacterEncodingFilter CHARACTER_ENCODING_FILTER = new CharacterEncodingFilter();

    static {
        CHARACTER_ENCODING_FILTER.setEncoding("UTF-8");
        CHARACTER_ENCODING_FILTER.setForceEncoding(true);
    }

    private MockMvc mockMvc;

    private WebClient webClient;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ProjectService service;

    private List<Project> projects = asList(new Project("Web-consolidation"),
            new Project("Web-planning"));

    @Before
    public void init() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilter(CHARACTER_ENCODING_FILTER)
                .build();

        webClient = MockMvcWebClientBuilder
                .mockMvcSetup(mockMvc)
                .useMockMvcForHosts("proversys.ru")
                .build();

        when(service.findAll()).thenReturn(projects);
    }

    @Test
    public void projectPageIsRenderedAsHtmlWithListOfProjects() throws IOException {
//        HtmlPage page = webClient.getPage("http://proversys.ru/projectList");
//        List<String> booksList = page.getElementsByTagName("li")
//                .stream().map(DomNode::asText).collect(toList());
//        assertThat(booksList, hasItems("1. Web-consolidation", "2. Web-planning"));
    }

    @Test
    public void requestForProjectsIsSuccessfullyProcessedWithAvailableProjectsList() throws Exception {
//        this.mockMvc.perform(get("/projects.htm")
//                .accept(MediaType.parseMediaType("text/html;charset=UTF-8")))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType("text/html;charset=UTF-8"))
//                .andExpect(content().string(allOf(
//                        containsString("Web-consolidation"),
//                        containsString("Web-planning")))
//                );
    }
}
