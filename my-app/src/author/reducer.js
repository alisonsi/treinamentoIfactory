import Actions from './actions';

const initialState =   
  {
      authors: [],
      isFetching: false,
      message: '',
      currentItem: {},
      editingItem: {
        firstName: '',
        lastName: '',
        email: '',
      },
      isSaving: false,
      isDeleting:false,
  }
  
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

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case FETCH_LIST_REQUEST:
      return {
        ...state,
        isFetching: true,
      };
    case FETCH_LIST_SUCCESS:
      return {
        ...state,
        isFetching: false,
        authors: action.authors,
        message: '',
      };
    case FETCH_LIST_FAILURE:
      return {
        ...state,
        message: action.error,
        isFetching: false,
        authors: [],
      }
    case CURRENT_ITEM_SELECT:
      return {
        ...state,
        currentItem: action.item,
        editingItem: action.item,
      };
      /**@Alison Santos */
    case EDITING_ITEM_CANCEL:
      return {
        ...state,
        editingItem: initialState.editingItem

      };
      /**@Alison Santos */
    case EDITING_ITEM_CHANGE:
      return{
        ...state,
        editingItem: action.item      
      }
      /**@Alison Santos */
    case EDITING_ITEM_DELETE_REQUEST:
      return{
        ...state,
        isDeleting:false,        
      }
      /**@Alison Santos */    
    case EDITING_ITEM_DELETE_SUCCESS:
      const authors = state.authors.filter(aut =>{
         return aut.url !== action.item.url
      })
        return{
          ...state,
          authors: authors,
          isDeleting:true,
        };
      /**@Alison Santos */    
    case EDITING_ITEM_DELETE_FAILURE:
        return{
          ...state,
          isDeleting:false,
        }
      /**@Alison Santos */    
    case EDITING_ITEM_SAVE_REQUEST:
      return {
        ...state,
        isSaving: true
      }

      /**@Alison Santos */  
    case EDITING_ITEM_SAVE_SUCCESS:{
      const item = action.editingItem;
      const author = {...item, url:item._links.author.href}     
      return{        
        ...state,
        author: state.authors.push(author),
        isSaving:false,
        editingItem: initialState.editingItem,        
      }
     }
      /**@Alison Santos */    
    case EDITING_ITEM_SAVE_FAILURE:
      return{
        ...state,
        isSaving:false,
        
      }
    
    
    default:
      return state;
  }
};

export default reducer;
