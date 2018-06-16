package org.thymeleaf.dialect.springdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.context.WebEngineContext;
import org.thymeleaf.dialect.springdata.util.Expressions;
import org.thymeleaf.dialect.springdata.util.PageUtils;
import org.thymeleaf.dialect.springdata.util.Strings;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

import static org.thymeleaf.dialect.springdata.util.Strings.*;

final class PaginationOnClickAttrProcessor extends AbstractAttributeTagProcessor {
    private static final String ATTR_NAME = "pagination-onclick";
    public static final int PRECEDENCE = 900;

    public PaginationOnClickAttrProcessor(final String dialectPrefix) {
        super(TemplateMode.HTML, dialectPrefix, null, false, ATTR_NAME, true, PRECEDENCE, false);
    }

    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName,
            String attributeValue, IElementTagStructureHandler structureHandler) {

        if (context instanceof WebEngineContext) {
            Object function = Expressions.evaluate(context, attributeValue);
            ((WebEngineContext) context).setVariable(Keys.PAGINATION_ONCLICK_KEY, function);
        }
    }

}
