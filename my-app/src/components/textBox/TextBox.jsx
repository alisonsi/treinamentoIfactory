import React from 'react';
import PropTypes from 'prop-types';

const componentName = props => {
/** @param e {Event} */
    const handleChange = e =>{
        e.preventDefault();
        e.stopPropagation();
        props.onChange(e.target.value);
    };

    return (
        <div>
            <input type="text" name="" value={props.value} onChange={handleChange}/>
        </div>
    );
};

componentName.propTypes = {
    
};

export default componentName;