import { connect } from 'react-redux';

import AuthorPage from '../components/AuthorPage';
import { 
  startEditing,
  cancelEditingItem, 
  deleteEditingItemRequest,
  saveEditingItemRequest,
  changeEditingItem } from '../actionCreators';



const mapStateToProps = ({
  authors,
  isFetching,
  message,
  currentItem,
  editingItem,
  isSaving,
}) => ({
  message,
  authors,
  editingItem,
  selectedId: currentItem.url,
  loading: isFetching || isSaving,
});

const mapDispatchToProps = dispatch => ({
  onEditItemClick: item => dispatch(startEditing(item)),
  
  /**@Alison Santos */
  onCancelEditing: () => dispatch( cancelEditingItem()),
  onDeleteItemClick: item => dispatch( deleteEditingItemRequest(item)),
  onSaveEditing: item => dispatch(saveEditingItemRequest(item)),
  onEditingItemChange: item => dispatch(changeEditingItem(item))
  
});

export default connect(mapStateToProps, mapDispatchToProps)(AuthorPage);
