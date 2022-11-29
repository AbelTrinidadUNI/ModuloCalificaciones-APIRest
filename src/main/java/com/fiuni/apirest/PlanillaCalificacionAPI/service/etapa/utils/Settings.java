package com.fiuni.apirest.PlanillaCalificacionAPI.service.etapa.utils;




import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Settings {
    //private static final Logger LOGGER = Logger.getLogger(Settings.class);
    //@Value(value = "${api.page-size}")
    public static final int PAGE_SIZE = 5;

    public static Boolean PROVOCAR_FALLO = false;
    public static final String CACHE_NAME = "platform-cache";
    @Value("${api.page-size}")
    String a;

    static{
        System.out.println("SOLUCIONAR LA PARTE DE LEER PROPERTIES PARA LA PAGINA: " + new Settings().a);

    }

}
