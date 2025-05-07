package require4Testing;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "_GenericFacesConverter")
public class _GenericFacesConverter implements Converter<Object> {

	private final _GenericDAO<Object> genericDAO = new _GenericDAO<>();


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }

        Object typeAttr = component.getAttributes().get("entityType");
        if (typeAttr == null || !(typeAttr instanceof Class)) {
            throw new IllegalArgumentException("entityType attribute missing or invalid on component " + component.getClientId());
        }

        @SuppressWarnings("unchecked")
        Class<Object> entityClass = (Class<Object>) typeAttr;

        genericDAO.setEntityClass(entityClass);
        try {
            Long id = Long.valueOf(value);
            return genericDAO.findById(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid ID: " + value, e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object == null) return "";

        genericDAO.setEntityClass(object.getClass());
        Object id = genericDAO.getPrimaryKey(object);
        return (id != null) ? id.toString() : "";
    }
}
