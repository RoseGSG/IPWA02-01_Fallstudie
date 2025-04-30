package require4Testing;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class RequirementDAO extends _GenericDAO<Requirement> {

    public RequirementDAO() {
        setEntityClass(Requirement.class);
    }
}
