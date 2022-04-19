package homework41.config;

import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.SimpleLocaleContext;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import org.springframework.web.server.i18n.LocaleContextResolver;

import java.util.Locale;

@Component(WebHttpHandlerBuilder.LOCALE_CONTEXT_RESOLVER_BEAN_NAME)
public class LocaleResolver implements LocaleContextResolver {

    private static final String LANG_PARAMETER_NAME = "lang";

    @Override
    public LocaleContext resolveLocaleContext(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        String languageFromParameter = request.getQueryParams().getFirst(LANG_PARAMETER_NAME);
        String languageFromRequestHeader = request.getHeaders().getAcceptLanguageAsLocales().get(0).getLanguage();
        Locale targetLocale = Locale.getDefault();
        if (languageFromParameter != null && !languageFromParameter.isEmpty()) {
            targetLocale = Locale.forLanguageTag(languageFromParameter);
        } else if (languageFromRequestHeader != null && !languageFromRequestHeader.isEmpty()) {
            targetLocale = Locale.forLanguageTag(languageFromRequestHeader);
        }
        return new SimpleLocaleContext(targetLocale);
    }

    @Override
    public void setLocaleContext(ServerWebExchange exchange, LocaleContext localeContext) {
        throw new UnsupportedOperationException("Not Supported");
    }
}
