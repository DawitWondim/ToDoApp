import { useEffect, useState} from "react"
import ToDoItem from "./components/todoitems"

function App() {

  const [todoitems, setToDoItems] = useState(null);


  useEffect(() => {
    if(!todoitems)
    {
    fetch("http://localhost:8080/api/todoitems")
    .then((response) => response.json())
    .then((data) => {console.log(data);
    setToDoItems(data);
      });
    }
}, [todoitems]);

function addNewToDoItem(){
  fetch("http://localhost:8080/api/todoitems", 
  {
  headers: {'content-type': 'application/json'}, 
  method: 'POST'})
  .then(response => response.json())
  .then((aTodoItem) => {
    setToDoItems([...todoitems, aTodoItem]);
  })

}

function handleDeleteToDoItem(item) {
    const updatedToDoItems = todoitems.filter((aTodoItem) => aTodoItem.id !== item.id);
    setToDoItems([...updatedToDoItems])
}
  
  return (
    <>
    <div>
        <button onClick = {addNewToDoItem}>Add New Item</button>
    </div>
    <div>
        {todoitems? todoitems.map((todoItem) => {
          return <ToDoItem key = {todoItem.id} data = {todoItem} emitDeleteToDoItem = {handleDeleteToDoItem}/>
        }): "loading data..."}
    </div>
    </>
  );
}

export default App;
