<#import "masterPage.ftl" as layout />
<@layout.page title="${todo.getName()}">
    <h1>${todo.getName()}</h1>

    <form action="/items/${todo.getId()}" method="post">
        <input type="text" name="itemName" placeholder="What needs to be done?">
    </form>

    <div class="items">
        <#list todo.getItems() as item>
            <#if item.isCompleted()>
                <div class="item done">
            <#else>
                <div class="item">
            </#if>                
                    <div class="view">                                    
                        <input type="checkbox" onclick="setItemCompleted(${todo.getId()}, ${item.getId()}, ${item.isCompletedS()}, location)" <#if item.isCompleted()> checked="checked" </#if>>
                        <span>${item.getName()}</span> <a onclick="deleteItem(${todo.getId()}, ${item.getId()})" class="destroy" href=""></a>
                    </div>
                </div>
        </#list>
    </div>
    <footer>
        <a class="clear" onclick="clearCompleted(${todo.getId()})" href="">Clear completed</a>
        <a href="/" class="clear">&lt; Return to list Management </a>
        <div class="count"><span class="countVal">${todo.getIncompletedItems()}</span> left</div>
    </footer>
</@layout.page>