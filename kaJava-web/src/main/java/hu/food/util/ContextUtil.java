package hu.food.util;

import org.primefaces.context.RequestContext;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ProjectStage;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class ContextUtil {

    public static final String HUNGARIAN_RULE = "< a,A < \u00e1,\u00c1 < b,B < c,C < cs,Cs < d,D < dz,Dz < dzs,Dzs < e,E < \u00e9,\u00c9 < f,F < g,G < gy,Gy < h,H < i,I < \u00ed,\u00cd < j,J < k,K < l,L < ly,Ly < m,M < n,N < ny,Ny < o,O < \u00f3,\u00d3 < \u00f6,\u00d6 < \u0151,\u0150 < p,P < q,Q < r,R < s,S < sz,Sz < t,T < ty,Ty < u,U < \u00fa,\u00da < \u00fc,\u00dc < \u0171,\u0170 < v,V < w,W < x,X < y,Y < z,Z < zs,Zs";

    public ContextUtil() {
    }

    /**
     * @return {@link RequestContext#isAjaxRequest()}
     */
    public static boolean isAjaxRequest() {
        return RequestContext.getCurrentInstance().isAjaxRequest();
    }

    public static Locale getLocaleFromCountry(String country) {
        Map<String, Locale> COUNTRY_TO_LOCALE_MAP = new HashMap<String, Locale>();
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale l : locales) {
            COUNTRY_TO_LOCALE_MAP.put(l.getCountry(), l);
        }
        return COUNTRY_TO_LOCALE_MAP.get(country);
    }

    public static void redirectToUrl(String url) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Collator createHungarianCollator() {
        try {
            return new RuleBasedCollator(HUNGARIAN_RULE);
        } catch (ParseException e) {

            return Collator.getInstance(new Locale("hu"));
        }
    }

    public static ValueExpression createValueExpression(FacesContext context, String expression) {
        return createValueExpression(context, expression, Object.class);
    }

    public static ValueExpression createValueExpression(FacesContext context, String expression, Class<?> expectedType) {
        Application application = context.getApplication();
        ExpressionFactory factory = application.getExpressionFactory();

        return factory.createValueExpression(context.getELContext(), createELExpression(expression), expectedType);
    }

    public static String createELExpression(String expression) {
        if (expression.startsWith("#{")) {
            return expression;
        }

        return "#{" + expression + "}";
    }

    public static void addMessage(String clientId, FacesMessage.Severity severity, String summary, String detail) {
        FacesContext fc = FacesContext.getCurrentInstance();

        fc.addMessage(clientId, new FacesMessage(severity, summary, detail));

        if (clientId != null) {
            update(clientId);
        }
    }

    public static void update(String componentId) {
        RequestContext rc = RequestContext.getCurrentInstance();

        rc.update(componentId);
    }

    public static boolean isProductionStage() {
        FacesContext fc = FacesContext.getCurrentInstance();

        return fc.isProjectStage(ProjectStage.Production);
    }

}
