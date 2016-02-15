<#import "masterPage.ftl" as layout />
<@layout.page title="List Management">
    <h1>List Management</h1>
    
    <form action="/" method="post">
    
        <input type="text" name="listName" placeholder="Type the name of the new list">
        
    </form>
    <div class="items">
    
    <#list groupTodoLists.getTodoLists() as todoLists>
        <div class="item">
            <div class="view">
                <a href="/items/${todoLists.getId()}"><span>${todoLists.getNameWithNumber()}</span></a> 
                <a class="destroy" onclick="deleteList('${todoLists.getName()}')" href=""></a>
            </div>
        </div>
    </#list>

    </div>
</@layout.page>