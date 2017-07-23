import Actions from './actions';

const {
  FETCH_LIST_REQUEST,
  FETCH_LIST_SUCCESS,
  FETCH_LIST_FAILURE,
  EDITING_ITEM_CHANGE,
  EDITING_ITEM_CANCEL,
  EDITING_ITEM_SAVE_REQUEST,
  EDITING_ITEM_SAVE_SUCCESS,
  EDITING_ITEM_SAVE_FAILURE,
  EDITING_ITEM_DELETE_REQUEST,
  EDITING_ITEM_DELETE_SUCCESS,
  EDITING_ITEM_DELETE_FAILURE,
  CURRENT_ITEM_SELECT,
} = Actions;

const fetchList = () => (dispatch, getState) => {
  dispatch({ type: FETCH_LIST_REQUEST });
  fetch('http://localhost:8080/authors', {
      mode: 'cors',
      headers: { 'Content-Type': 'application/json' },
    })
    .then(response => response.json())
    .then(({ _embedded }) => {
      const authors = _embedded.authors
        .map(a => ({ ...a, url: a._links.self.href }));
      dispatch({
        authors,
        type: FETCH_LIST_SUCCESS,
      });
    })
    .catch(() => dispatch({
      type: FETCH_LIST_FAILURE,
      error: 'Ocorreu um problema ao carregar os dados do servidor',
    }));
};
  /**@Alison Santos */
const saveEditingItemRequest = item => (dispatch, getState) =>{
  const {editingItem} = getState();
  
  dispatch({ 
  editingItem,
  type: EDITING_ITEM_SAVE_REQUEST 
  });
  fetch('http://localhost:8080/authors', {
      method:'POST',
      mode: 'cors',
      headers: { 'Content-Type': 'application/json' },
      body:JSON.stringify(editingItem),
    })
    .then(response => response.json())
    .then( author => {
      
      dispatch({
        editingItem: author,
        type: EDITING_ITEM_SAVE_SUCCESS,
      });
    })
    .catch(() => dispatch({
      type: EDITING_ITEM_SAVE_FAILURE,
      error: 'Ocorreu um problema ao salvas os dados',
    }));
}

/**@Alison Santos */
const changeEditingItem = item => ({
  item,
  type: EDITING_ITEM_CHANGE,
});

/**@Alison Santos */
const cancelEditingItem = item => ({ 
  type: EDITING_ITEM_CANCEL 
});

/**@Alison Santos */
const deleteEditingItemRequest = item => (dispatch, getState) => {
  dispatch({ 
    type: EDITING_ITEM_DELETE_REQUEST });

  fetch(item.url, {
      mode: 'cors',
      method: 'DELETE',
      headers: { 'Content-Type': 'application/json' },
    })
    .then(
        data=>
        {
          if(data.ok)
          {
            dispatch({
              item,
              type: EDITING_ITEM_DELETE_SUCCESS,
            })
          }
          else
          {
            dispatch({
              type: EDITING_ITEM_DELETE_FAILURE,
              error: 'Este author não existe mais',
            })
          }
        }
    )
    .catch(() => dispatch({
      type: EDITING_ITEM_DELETE_FAILURE,
      error: 'Ocorreu um problema ao deletar o author',
      })
    )
};

const startEditing = item => ({
  item,
  type: CURRENT_ITEM_SELECT,
});

export {
  fetchList,
  startEditing,
  cancelEditingItem,
  deleteEditingItemRequest,
  saveEditingItemRequest,
  changeEditingItem,
};
