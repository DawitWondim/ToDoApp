import React, {useEffect, useState} from 'react'

const TodoItem = (props) => 
{
    const {emitDeleteToDoItem} = props;
    const [todoItem, setTodoItem] = useState(props.data);
    const [isDirty, setIsDirty] = useState(false);

    useEffect(() => 
    {
        if(isDirty)
        {
        fetch(`http://localhost:8080/api/todoitems/${todoItem.id}`, 
        {method:'PUT', 
        headers: {"content-type": "application/json"},  
        body:JSON.stringify(todoItem)})
            .then((response) => response.json())
            .then((data) => 
            {
                setIsDirty(false);
                setTodoItem(data);
            });
        }
    }, [todoItem, isDirty]);

function updateTask(e)
{
    setIsDirty(true);
    setTodoItem({...TodoItem, task: e.target.value});
}

function deleteToDoItem()
{
    fetch(`http://localhost:8080/api/todoitems/${todoItem.id}`, 
        {
        method:'DELETE', 
        headers: {"content-type": "application/json"},  
        body:JSON.stringify(todoItem)})
            .then( (response) => {emitDeleteToDoItem(todoItem)});
}
    return (
        <div>
            <input 
            type ="checkbox" 
            checked = {todoItem.isDone} 
            onChange = {() => {setIsDirty(true); setTodoItem({...todoItem, isDone: !todoItem.isDone})}}/>
            {todoItem.isDone? (<span style = {{textDecoration: "line-through" }}>{todoItem.task}</span>) : (<input type = "text" value = {todoItem.task} onChange = {updateTask}/>)}
            <span style = {{marginLeft: '2 rem', cursor: "pointer"}} onClick = {deleteToDoItem}>🗑️</span>
        </div>
    );
};

export default TodoItem;




